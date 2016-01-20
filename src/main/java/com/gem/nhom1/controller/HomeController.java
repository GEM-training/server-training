package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Promotion;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.PromotionService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String  home(ModelMap mm){
       // dealerService.save(new Dealer("Yamaha VietNam" , "Ha Noi"));
        List<Dealer> list =  dealerService.getListDealer();
        mm.addAttribute("dealers"  ,  list);

        Dealer d = dealerService.getDealerById(1);
        mm.addAttribute("ins"  ,  d.getInventorys());

        LocalDate start = new LocalDate();
        LocalDate end = new LocalDate();
        Dealer dealer = new Dealer();
        Unit unit = new Unit();
        Promotion promotion = new Promotion(0.5, start, end, unit, dealer);
        List<Promotion> promotions = promotionService.getListPromotion();

        mm.addAttribute("size"  ,  promotions.size());

        return "xinchao";
    }


}
