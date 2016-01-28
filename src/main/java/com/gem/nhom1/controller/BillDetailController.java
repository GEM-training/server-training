package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.BillDetailService;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.UnitService;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by phuongtd on 21/01/2016.
 */
@Controller
@RequestMapping("/bill_detail")
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
        return billDetailService.insert(billDetail);

    }

    @RequestMapping(value = "/list")
    public @ResponseBody ResponseDTO
    list(@RequestParam (value = "page",defaultValue = "1") int page){

        return  billDetailService.getList(page);
    }




    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public @ResponseBody
    ResponseDTO
    update(@RequestBody BillDetail billDetail) {
        return billDetailService.update(billDetail);

    }

    @RequestMapping("delete/{unitId}/{billId}")
    public @ResponseBody ResponseDTO update(@PathVariable("unitId") int unitId, @PathVariable("billId") int billId) {

        Unit unit = unitService.getById(unitId);

        Bill bill = billService.getById(billId);

        BillDetailId billDetailId = new BillDetailId(bill, unit);

        return billDetailService.delete(billDetailId);
    }


}
