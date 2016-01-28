package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.BillDetailService;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.UnitService;
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
    @ResponseBody ResponseDTO insert(@RequestBody BillDetail billDetail) {
        Set<ConstraintViolation<BillDetail>> constraintViolations = validator.validate(billDetail);

        if(constraintViolations.size() > 0){

            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , constraintViolations.iterator().next().getMessage() , null);
        }
        try {
            billDetailService.insert(billDetail);
        } catch (Exception e){
            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

        return  new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);

    }

    @RequestMapping(value = "/list")
    public @ResponseBody ResponseDTO
    list(@RequestParam (value = "page",defaultValue = "1") int page){

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , billDetailService.getList(page)) ;
    }




    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public @ResponseBody
    ResponseDTO
    update(@RequestBody BillDetail billDetail) {
        Set<ConstraintViolation<BillDetail>> constraintViolations = validator.validate(billDetail);

        if(constraintViolations.size() > 0){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());

            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR ,constraintViolations.iterator().next().getMessage() , null );
        }
        try {
            billDetailService.update(billDetail);
        } catch (Exception e){
            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR ,e.getMessage() , null );
        }

        return  new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);

    }

    @RequestMapping("delete/{unitId}/{billId}")
    public @ResponseBody ResponseDTO update(@PathVariable("unitId") int unitId, @PathVariable("billId") int billId) {

        Unit unit = unitService.getById(unitId);

        Bill bill = billService.getById(billId);

        BillDetailId billDetailId = new BillDetailId(bill, unit);

        try {
            billDetailService.delete(billDetailId);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }


}
