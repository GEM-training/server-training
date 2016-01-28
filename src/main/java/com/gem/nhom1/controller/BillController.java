package com.gem.nhom1.controller;

import com.gem.nhom1.dao.BillDao;
import com.gem.nhom1.model.*;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.CustomerService;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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


    @RequestMapping("/insert")
    public @ResponseBody String insert(@RequestBody Bill bill) {

        return billService.insert(bill) + "";
    }

    @RequestMapping("/update")
    public
    @ResponseBody
    String update() {

        Bill bill = billService.getById(3);
        bill.setState("Update state");
        billService.update(bill);
        return "ok";
    }

    @RequestMapping("/list/{page}")
    public
    @ResponseBody
    String list(@PathVariable(value = "page") int page) {

        List<Bill> bills = billService.getList(page);
        String kq = "";

        for (int i = 0; i < bills.size(); i++) {
            kq = kq + "Bill id: " + bills.get(i).getBillId() + " State: " + bills.get(i).getState() + "<br>";
        }
        return kq;
    }

    @RequestMapping("delete/{billId}")
    public
    @ResponseBody
    String delete(@PathVariable("billId") int billId) {

        return billService.delete(billId) + "";

    }



}
