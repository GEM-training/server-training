package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.entities.Inventory;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.service.InventoryService;
import com.gem.nhom1.util.Constant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("/insert")
    public @ResponseBody ResponseDTO insert(@RequestBody @Valid Inventory inventory, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        inventoryService.insert(inventory);

        return  new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO getList(@RequestParam(value = "start") int start){
        List<Inventory> inventories = inventoryService.getList(start);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", inventories);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseDTO delete(@PathVariable("id") Integer id){

        try {
            inventoryService.delete(id);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, e.getMessage(), null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid Inventory inventory,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        inventoryService.update(inventory);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping("/{id}")
    public @ResponseBody ResponseDTO getitem(@PathVariable int id){
        Inventory inventory = inventoryService.getById(id);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", inventory);
    }

}
