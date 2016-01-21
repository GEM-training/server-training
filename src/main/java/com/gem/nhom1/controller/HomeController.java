package com.gem.nhom1.controller;

import com.gem.nhom1.dao.BillDetailDao;
import com.gem.nhom1.dao.DealerDao;
import com.gem.nhom1.model.*;
import com.gem.nhom1.service.*;
import net.arnx.jsonic.JSON;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody String  home(ModelMap mm){

        /*Dealer dealer = dealerService.getDealerById(1);
        Customer customer = customerService.getCustomerById(1);
        Staff staff = staffService.getStaffById(1);

        Bill bill = new Bill();
        bill.setDealer(dealer);
        bill.setStaff(staff);
        bill.setCustomer(customer);
        bill.setState("Waiting...");

        billService.save(bill);

        Unit unit1 = unitService.getUnitById(1);
        Unit unit3 = unitService.getUnitById(3);

        BillDetail billDetail = new BillDetail();
        billDetail.setUnit(unit1);
        billDetail.setBill(bill);
        billDetail.setQuantity(3);

        BillDetail billDetail1 = new BillDetail();
        billDetail1.setUnit(unit3);
        billDetail1.setBill(bill);
        billDetail1.setQuantity(1);

        billDetailService.save(billDetail);
        billDetailService.save(billDetail1);*/



        //BillDetail billDetail = billDetailService.getBillDetailById(1);
        Bill bill = billService.getBillById(1);


        return JSON.encode(bill.getBillDetail().iterator().next());
    }


}
