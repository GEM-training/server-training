package com.gem.nhom1.controller;

import com.gem.nhom1.dao.BillDao;
import com.gem.nhom1.model.*;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.CustomerService;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by phuongtd on 21/01/2016.
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private DealerService dealerService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private BillService billService;

    @Autowired
    private BillDao billDao;

    @Autowired
    private Validator validator;

    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Bill bill) {

        Set<ConstraintViolation<Bill>> constraintViolations = validator.validate(bill);

        if (constraintViolations.size() > 0) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());

            return new ResponseEntity<Void>(httpHeaders, HttpStatus.EXPECTATION_FAILED);
        }
        billService.insert(bill);

        return new ResponseEntity<Bill>(bill, HttpStatus.OK);

    }


    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public
    ResponseEntity<?>  update(@RequestBody Bill bill) {
        Set<ConstraintViolation<Bill>> constraintViolations = validator.validate(bill);

        if(constraintViolations.size() > 0){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());

            return  new ResponseEntity<Void>(httpHeaders , HttpStatus.EXPECTATION_FAILED);
        }

        billService.update(bill);

        return new ResponseEntity<Bill>(HttpStatus.OK);

    }

    @RequestMapping("/list")
    public
    ResponseEntity<List<Bill>>
    list(@RequestParam(value = "page" , defaultValue = "1") int page) {

        List<Bill> bills = billService.getList(page);
        return new ResponseEntity<List<Bill>>(bills , HttpStatus.OK);
    }

    @RequestMapping("delete/{billId}")
    public
    ResponseEntity<?> delete(@PathVariable("billId") int billId) {

        try {
            billService.delete(billId);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e,HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}
