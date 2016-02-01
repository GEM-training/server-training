package com.gem.nhom1.controller;

import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.model.ResponseDTO;
import com.gem.nhom1.service.InventoryService;
import com.gem.nhom1.util.Constant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by nghicv on 21/01/2016.
 */

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private Validator validator;

    private static final Logger logger = Logger.getLogger(InventoryController.class);

    @RequestMapping("/insert")
    public @ResponseBody ResponseDTO insert(@RequestBody Inventory inventory){
        Set<ConstraintViolation<Inventory>> constraintViolations = validator.validate(inventory);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(),null);
        }
        try{
           inventoryService.insert(inventory);
        }catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, e.getMessage(), null);
        }
        return  new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO getList(@RequestParam(value = "page") int page){
        List<Inventory> inventories = inventoryService.getList(page);
        logger.error("This is Error message");
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", inventories);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseDTO delete(@RequestBody Integer id){

        try {
            inventoryService.delete(id);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, e.getMessage(), null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody Inventory inventory){
        Set<ConstraintViolation<Inventory>> constraintViolations = validator.validate(inventory);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(), null);
        }
        inventoryService.update(inventory);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping("/{id}")
    public @ResponseBody ResponseDTO getitem(@PathVariable int id){
        Inventory inventory = inventoryService.getById(id);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", inventory);
    }

}
