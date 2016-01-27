package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Promotion;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.PromotionService;
import com.gem.nhom1.service.UnitService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
private Validator validator;
    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Promotion promotion){

        Dealer dealer = dealerService.getById(1);
        promotion.setDealer(dealer);
        Set<ConstraintViolation<Promotion>> constraintViolations = validator.validate(promotion);

        if (constraintViolations.size() > 0) {
            return new ResponseEntity<String>(constraintViolations.iterator().next().getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
        promotionService.insert(promotion);
        return new ResponseEntity<Promotion>(promotion,HttpStatus.OK);
    }

    @RequestMapping("/all/dealer/{id}")
    public ResponseEntity<List<Promotion>> getList(@PathVariable("id") Integer id){
        List<Promotion> promotions = dealerService.getListPromotions(id);
        return new ResponseEntity<List<Promotion>>(promotions,HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            promotionService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e,HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Promotion promotion){

        Set<ConstraintViolation<Promotion>> constraintViolations = validator.validate(promotion);

        if (constraintViolations.size() > 0) {
            return new ResponseEntity<String>(constraintViolations.iterator().next().getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

        promotionService.update(promotion);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping("/query/{id}")
    public @ResponseBody String getItem(@PathVariable int id){
        Promotion promotion = promotionService.getById(id);

        return "success";
    }

}
