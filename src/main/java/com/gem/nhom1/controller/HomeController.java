package com.gem.nhom1.controller;

import com.gem.nhom1.dao.CustomerDao;
import com.gem.nhom1.model.Customer;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.CustomerService;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by vanhop on 1/18/16.
 */

@RestController
public class HomeController {


    @Autowired
    private CustomerService customerService;
    @Autowired
    private UnitService unitService;

    @RequestMapping("/")
    public void home(){

       // customerService.save(new Customer("test","123","cccc"));
        unitService.save(new Unit("Oto",0));

    }

}
