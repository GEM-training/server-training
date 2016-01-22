package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/insert")
    public @ResponseBody String  home(ModelMap mm){

        Dealer dealer = new Dealer("Test Dealer" , "HN");

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
    public @ResponseBody String list(){
        List<Dealer> list = dealerService.getList();
        String result = "";
        for(int i = 0 ; i < list.size() ; i++){
            Dealer d = list.get(i);
            result = result + "ID: " + d.getDealerId()+ " Name: "+ d.getName() + " Address: " +  d.getAddress() +" <br><hr>";
        }
        return result;
    }

    @RequestMapping("/delete/{dealerId}")
    public @ResponseBody String delete(@PathVariable("dealerId") int dealerId){

        return "Delete: "+ dealerService.delete(dealerId);
    }

    @RequestMapping("/detail/{dealerId}")
    public @ResponseBody String detail(@PathVariable("dealerId") int dealerId){
        String result = "";
        Dealer d = dealerService.getById(dealerId);
        result +=   "ID: " + d.getDealerId()+ " Name: "+ d.getName() + " Address: " +  d.getAddress() +" <br><hr>";

        result += "<h3>Danh sach cac Unit</h3>";
        List<UnitDealer> unitDealers = dealerService.getListUnitDealer(dealerId);
        for(int i =0 ; i< unitDealers.size() ; i++){
            UnitDealer unitDealer = unitDealers.get(i);
            Unit unit = unitDealer.getUnit();
            result += "Unit ID: "+unit.getUnitId() + " Type: " + unit.getType() + " Price: " +unitDealer.getPrice() + "<br>";
        }

        result += "<hr><h3>Danh sach cac Inventory</h3>";
        List<Inventory> inventories = dealerService.getListInventory(dealerId);
        for(int i = 0 ; i< inventories.size(); i++){
            Inventory inventory = inventories.get(i);
            result += "Inventory ID: " + inventory.getInventoryId() + " Name: " + inventory.getName() + " Address: " + inventory.getAddress() + "<br>";
        }

        result += "<hr><h3>Danh sach cac Staff</h3>";

        List<Staff> staffs = dealerService.getListStaff(dealerId);
        for(int i = 0 ; i < staffs.size() ; i++){
            Staff staff = staffs.get(i);
            result += "Staff ID: " + staff.getStaffId() + " Name: " + staff.getName() + " Address: " + staff.getAddress() + " Phone: "+ staff.getPhone();
        }

        result += "<hr><h3>Danh sach cac Bill v BillDetail</h3>";

        List<Bill> bills = dealerService.getListBill(dealerId);

        double Total = 0;

        for(int i = 0 ; i < bills.size() ; i++){
            double total = 0;
            Bill bill = bills.get(i);
            result += "<br>Bill ID: " + bill.getBillId() + " Customer: " + bill.getCustomer().getName() + " State: "+ bill.getState() + "<br>Detail:<br>" ;

            List<BillDetail> billDetails = new ArrayList<BillDetail>( bill.getBillDetail() );

            for(int j = 0 ; j < billDetails.size() ; j++){

                BillDetail billDetail1 = billDetails.get(j);
                total = total + billDetail1.getQuantity() * dealerService.getPrice(dealerId , billDetail1.getUnit().getUnitId());
                result += "Unit: " + billDetail1.getUnit().getType() + " So luong: " + billDetail1.getQuantity() + "<br>";
            }
            result += "Sum = "+ total+ "<br>";
            Total += total;
            result += "<br>-----<br>";

        }
        result += "=> Total: " +Total;

        return result;

    }



}
