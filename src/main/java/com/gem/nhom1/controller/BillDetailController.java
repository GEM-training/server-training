package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.BillDetailService;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.UnitService;
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
@RequestMapping("/billDetail")
public class BillDetailController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private BillService billService;

    @Autowired
    private BillDetailService billDetailService;

    @Autowired
    private Validator validator;


    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public
    ResponseEntity<?> insert(@RequestBody BillDetail billDetail) {
        Set<ConstraintViolation<BillDetail>> constraintViolations = validator.validate(billDetail);

        if(constraintViolations.size() > 0){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());

            return  new ResponseEntity<Void>(httpHeaders , HttpStatus.EXPECTATION_FAILED);
        }
        billDetailService.insert(billDetail);

        return  new ResponseEntity<BillDetail>(billDetail , HttpStatus.OK);

    }

    @RequestMapping(value = "/list")
    public ResponseEntity<List<BillDetail>>
    list(@RequestParam (value = "page",defaultValue = "1") int page){
        return new ResponseEntity<List<BillDetail>>(billDetailService.getList(page) , HttpStatus.OK);
    }




    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public
    ResponseEntity<?>
    update(@RequestBody BillDetail billDetail) {
        Set<ConstraintViolation<BillDetail>> constraintViolations = validator.validate(billDetail);

        if(constraintViolations.size() > 0){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());

            return  new ResponseEntity<Void>(httpHeaders , HttpStatus.EXPECTATION_FAILED);
        }
        billDetailService.update(billDetail);

        return  new ResponseEntity<BillDetail>(billDetail , HttpStatus.OK);

    }

    @RequestMapping("delete/{unitId}/{billId}")
    public ResponseEntity<?> update(@PathVariable("unitId") int unitId, @PathVariable("billId") int billId) {

        Unit unit = unitService.getById(unitId);

        Bill bill = billService.getById(billId);

        BillDetailId billDetailId = new BillDetailId(bill, unit);

        try {
            billDetailService.delete(billDetailId);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
