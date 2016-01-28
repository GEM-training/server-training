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
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody void insert(@RequestBody Promotion promotion){

        Dealer dealer = dealerService.getById(1);
        promotion.setDealer(dealer);
        promotionService.insert(promotion);
    }

    @RequestMapping("/all/dealer/{id}")
    public @ResponseBody List<Promotion> getList(@PathVariable("id") Integer id){
        List<Promotion> promotions = dealerService.getListPromotions(id);
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
