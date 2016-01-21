package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Controller
@RequestMapping("/home")
@Transactional
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
    public  String  home(ModelMap mm){

        List<Dealer> list = dealerService.getListDealer();

        Dealer d = dealerService.getDealerById(1);
        mm.addAttribute("dealers", list);


        mm.addAttribute("bills", d.getBills());

        mm.addAttribute("uds", d.getUnitDealers());

        return "xinchao";
    }


}