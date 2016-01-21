package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
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
    private BillDetailService billDetailService;

    @Autowired
    private UnitDealerService unitDealerService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private DealerService dealerService;

    @Autowired
    private BillService billService;

    @RequestMapping("/demo")
    public @ResponseBody String  home(ModelMap mm){

        //UnitDealerId id = new UnitDealerId(1,1);

       // UnitDealer unitDealer = unitDealerService.getById(id);
        Unit unit = unitService.getById(3);
        Bill bill = billService.getById(2);

        BillDetailId id = new BillDetailId(bill,unit);
        BillDetail billDetail = billDetailService.getById(id);
        return "Ok";

    }


}
