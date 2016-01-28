package com.gem.nhom1.controller;

import com.gem.nhom1.dao.BillDao;
import com.gem.nhom1.model.*;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.CustomerService;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.StaffService;
import com.gem.nhom1.util.Constant;
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
    public @ResponseBody ResponseDTO insert(@RequestBody Bill bill) {

        Set<ConstraintViolation<Bill>> constraintViolations = validator.validate(bill);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , constraintViolations.iterator().next().getMessage() , null );
        }
        try {
            billService.insert(bill);
        } catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null );
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);

    }


    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public
    @ResponseBody ResponseDTO update(@RequestBody Bill bill) {

        Set<ConstraintViolation<Bill>> constraintViolations = validator.validate(bill);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , constraintViolations.iterator().next().getMessage() , null );
        }
        try {
            billService.update(bill);
        } catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null );
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }

    @RequestMapping("/list")
    public
    @ResponseBody ResponseDTO
    list(@RequestParam(value = "page" , defaultValue = "1") int page) {

        List<Bill> bills = billService.getList(page);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , bills);
    }

    @RequestMapping("delete/{billId}")
    public
    @ResponseBody ResponseDTO delete(@PathVariable("billId") int billId) {

        try {
            billService.delete(billId);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }



}
