package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Promotion;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.PromotionService;
import com.gem.nhom1.service.UnitService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 *
 *
 */

@Controller
@RequestMapping("/promotion")
public class
PromotionController {
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private DealerService dealerService;

    @Autowired
    private UnitService unitService;

    @RequestMapping("/insert")
    public @ResponseBody
    String insert(ModelMap modelMap){
        Dealer dealer = dealerService.getById(1);
        Unit unit = unitService.getById(1);
        LocalDate start = new LocalDate("2016-12-20");
        LocalDate end = new LocalDate("2016-11-20");
        Promotion promotion = new Promotion(0.5, start, end, unit, dealer);
        int id = promotionService.insert(promotion);
        return "Success";
    }

    @RequestMapping("/all")
    public @ResponseBody List<Promotion> getList(ModelMap modelMap){
        List<Promotion> promotions = promotionService.getList();

        return promotions;
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String delete(ModelMap modelMap, @PathVariable int id){
        boolean deleted = promotionService.delete(id);
        return "Success";
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String update(ModelMap modelMap, @PathVariable int id){
        Promotion promotion = promotionService.getById(id);
        promotion.setSaleOff(0.9);
        promotionService.update(promotion);
        return "Success";
    }

    @RequestMapping("/{id}")
    public @ResponseBody String getItem(ModelMap modelMap, @PathVariable int id){
        Promotion promotion = promotionService.getById(id);

        return "success";
    }

}
