package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by phuongtd on 21/01/2016.
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DealerService dealerService;

    @RequestMapping("/insert")
    public @ResponseBody String insert(){

        Dealer dealer = dealerService.getById(1);
        Staff staff = new Staff("Nguyen Van Hop","199","Ha Noi",dealer);
        staffService.insert(staff);

        return "Sucess";
    }

    @RequestMapping("/query/{id}")
    public @ResponseBody Staff query(@PathVariable("id") Integer id){
        Staff staff = staffService.getById(id);
        //Dealer dealer = staff.getDealer();

        return staff;
    }

    @RequestMapping("/query/all")
    public @ResponseBody String queryAll(){
        List<Staff> staffList = staffService.getList();

        return "Success";
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id){
        Staff staff = staffService.getById(id);
        staff.setName("Phuong Nghi");
        staffService.update(staff);

        return "Success";
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id){

        if(staffService.delete(id))
            return "Id + " + id + " have deleted";
        return "there are some error";
    }
}
