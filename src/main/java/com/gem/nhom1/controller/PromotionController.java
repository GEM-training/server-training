package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.PromotionService;
import com.gem.nhom1.service.UnitService;
import com.gem.nhom1.util.Constant;
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
    public @ResponseBody
    ResponseDTO insert(@RequestBody Promotion promotion){

        Dealer dealer = dealerService.getById(1);
        promotion.setDealer(dealer);
        Set<ConstraintViolation<Promotion>> constraintViolations = validator.validate(promotion);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(), null);
        }

        try {
            promotionService.insert(promotion);
        } catch(Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(), null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping("/all/dealer/{id}")
    public @ResponseBody ResponseDTO getList(@PathVariable("id") Integer id){
        List<Promotion> promotions = dealerService.getListPromotions(id);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",promotions);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseDTO delete(@PathVariable int id){
        try {
            promotionService.delete(id);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody Promotion promotion){

        Set<ConstraintViolation<Promotion>> constraintViolations = validator.validate(promotion);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(),null);
        }
        try {
            promotionService.update(promotion);
        }catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping("/query")
    public @ResponseBody ResponseDTO getItem(@RequestParam(value = "page" ,  defaultValue = "1") int id){
        Promotion promotion = promotionService.getById(id);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",promotion);
    }

}