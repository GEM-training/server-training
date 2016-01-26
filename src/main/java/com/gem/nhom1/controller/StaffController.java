package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.util.Methods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody void insert(@RequestBody Staff staff){
        Dealer dealer = dealerService.getById(1);
        staff.setDealer(dealer);
        staffService.insert(staff);
    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public @ResponseBody Staff query(@PathVariable("id") Integer id){
        Staff staff = staffService.getById(id);
        return staff;
    }

    @RequestMapping("/query/all")
    public @ResponseBody List<Staff> queryAll(){
        List<Staff> staffList = staffService.getList();
        return staffList;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody void update(@RequestBody Staff staff){
        staffService.update(staff);
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody Boolean delete(@PathVariable("id") Integer id){
        return staffService.delete(id);
    }
}
