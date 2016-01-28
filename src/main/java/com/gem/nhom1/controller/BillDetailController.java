package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.BillDetailService;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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


    @RequestMapping(value = "/insert")
    public
    @ResponseBody
    String insert() {

        Bill bill = billService.getById(1);

        Unit unit1 = unitService.getById(1);

        Unit unit3 = unitService.getById(3);

        BillDetailId billDetailId1 = new BillDetailId(bill, unit1);

        BillDetailId billDetailId2 = new BillDetailId(bill, unit3);

        BillDetail billDetail1 = new BillDetail(billDetailId2, 3);

        BillDetailId id = billDetailService.insert(billDetail1);

        return "ok";
    }

    @RequestMapping(value = "/list")
    public @ResponseBody
    List<BillDetail> list(@RequestParam (value = "page") int page){
        return billDetailService.getList(page);
    }




    @RequestMapping("/update/{unitId}/{billId}/{quantity}")
    public
    @ResponseBody
    String update(@PathVariable("unitId") int unitId, @PathVariable("billId") int billId, @PathVariable("quantity") int quantity) {

        Unit unit = unitService.getById(unitId);

        Bill bill = billService.getById(billId);

        BillDetailId billDetailId = new BillDetailId(bill, unit);

        BillDetail billDetail = billDetailService.getById(billDetailId);

        billDetail.setQuantity(quantity);

        billDetailService.update(billDetail);

        return "OK";
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
