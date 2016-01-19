package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.User;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private DealerService dealerService;

    @RequestMapping("/demo")
    public String  home(ModelMap mm){
       // dealerService.save(new Dealer("Yamaha VietNam" , "Ha Noi"));
        List<Dealer> list =  dealerService.getListDealer();
        mm.addAttribute("dealers"  ,  list);

        Dealer d = dealerService.getDealerById(1);
        mm.addAttribute("ins"  ,  d.getInventorys());
        return "xinchao";
    }


}
package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.User;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private DealerService dealerService;

    @RequestMapping("/demo")
    public String  home(ModelMap mm){
       // dealerService.save(new Dealer("Yamaha VietNam" , "Ha Noi"));
        List<Dealer> list =  dealerService.getListDealer();
        mm.addAttribute("dealers"  ,  list);

        Dealer d = dealerService.getDealerById(1);
        mm.addAttribute("ins"  ,  d.getInventorys());
        return "xinchao";
    }


}
