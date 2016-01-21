package com.gem.nhom1.controller;

import com.gem.nhom1.model.Bill;
import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private DealerService dealerService;

    @Autowired
    private BillService billService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private BillDetailService billDetailService;

    @RequestMapping("/demo")
    public @ResponseBody String  home(ModelMap mm){

        Bill bill = billService.getBillById(2);
        bill.setState("Van hop 3");
        billService.update(bill);
        return "OK";
    }


}
