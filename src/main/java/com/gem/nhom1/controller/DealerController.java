package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Controller
@RequestMapping("/dealer")
public class DealerController {

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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody String  insert(@RequestBody Dealer dealer){

        //Dealer dealer = new Dealer("Test Dealer" , "HN");

        return dealerService.insert(dealer)+"";

    }
    @RequestMapping("/update")
    public @ResponseBody String update(){
        Dealer dealer = dealerService.getById(5);
        dealer.setName("Demo update");
        dealerService.update(dealer);
        return "OK";
    }

    @RequestMapping("/list")
    public @ResponseBody List<Dealer> list(@RequestParam(value = "page") int page){
        List<Dealer> list = dealerService.getList(page);

        return list;
    }

    @RequestMapping("/delete/{dealerId}")
    public @ResponseBody String delete(@PathVariable("dealerId") int dealerId){

        try {
            dealerService.delete(dealerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    @RequestMapping("/detail/{dealerId}")
    public @ResponseBody Dealer detail(@PathVariable("dealerId") int dealerId){
        Dealer d = dealerService.getById(dealerId);


        return d;

    }

    @RequestMapping("/getListInventory/{dealerId}")
    public @ResponseBody List<Inventory> getListInventory(@PathVariable("dealerId") int dealerId){
        List<Inventory> inventories = dealerService.getListInventory(dealerId);

        return  inventories;
    }

    @RequestMapping("/getListStaff/{dealerId}")
    public @ResponseBody List<Staff> getListStaff(@PathVariable("dealerId") int dealerId){
        List<Staff> staffs = dealerService.getListStaff(dealerId);

        return  staffs;
    }

    @RequestMapping("getListUnit/{dealerId}")
    public @ResponseBody List<UnitDealer> getListUnitDealers(@PathVariable("dealerId") int dealerId){
        List<UnitDealer> unitDealers = dealerService.getListUnitDealer(dealerId);

        return  unitDealers;
    }

    @RequestMapping("getListBill/{dealerId}")
    public @ResponseBody List<Bill> getListBill(@PathVariable("dealerId") int dealerId){
        List<Bill> bills = dealerService.getListBill(dealerId);

        return bills;
    }

    @RequestMapping("billDetail/{billId}")
    public  @ResponseBody Bill billDetail(@PathVariable("billId") int billId) {
        Bill bill;

        bill = billService.getById(billId);
        return bill;
    }

    @RequestMapping("/listBillDetail/{billId}")
    public @ResponseBody List<BillDetail> query(@PathVariable("billId") int billId){
        List<BillDetail> billDetails= billService.getListBillDetail(billId);

        return billDetails;

    }



}
