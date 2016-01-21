package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Promotion;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.PromotionService;
import net.arnx.jsonic.JSON;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
    private PromotionService promotionService;

    @RequestMapping("/demo")
    public @ResponseBody  String  home(ModelMap mm){
       // dealerService.save(new Dealer("Yamaha VietNam" , "Ha Noi"));
        List<Dealer> list =  dealerService.getListDealer();
        mm.addAttribute("dealers"  ,  list);

        Dealer d = dealerService.getDealerById(1);
        mm.addAttribute("ins"  ,  d.getInventorys());


        mm.addAttribute("bills"  ,  d.getBills());

        mm.addAttribute("uds"  ,  d.getUnitDealers());

        return JSON.encode(d.getBills().iterator());
    }


}
