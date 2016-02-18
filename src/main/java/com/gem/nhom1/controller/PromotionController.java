package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.entities.Promotion;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.PromotionService;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.sql.SQLException;
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO insert(@RequestBody @Valid Promotion promotion, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        promotionService.insert(promotion);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO getList(@RequestParam(value = "start" , defaultValue = "1") Integer start){
        List<Promotion> promotions = dealerService.getListPromotions(start);
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
    public @ResponseBody ResponseDTO update(@RequestBody @Valid Promotion promotion,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        promotionService.update(promotion);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping("/{id}")
    public @ResponseBody ResponseDTO getItem(@PathVariable("id") int id){
        Promotion promotion = promotionService.getById(id);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",promotion);
    }

}