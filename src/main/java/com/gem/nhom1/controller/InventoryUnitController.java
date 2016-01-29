package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.*;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.InventoryService;
import com.gem.nhom1.service.InventoryUnitService;
import com.gem.nhom1.service.UnitService;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by phuongtd on 21/01/2016.
 */
@Controller
@RequestMapping("/inventory_unit")
public class InventoryUnitController {

    @Autowired
    private InventoryUnitService inventoryUnitService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private DealerService dealerService;


    @RequestMapping("/inventory/{inventory_id}/dealer/{dealer_id}")
    public @ResponseBody
    ResponseDTO getList(@PathVariable("dealer_id") Integer dealerId, @PathVariable("inventory_id") Integer inventoryId){

        Dealer dealer = dealerService.getById(dealerId);

        Inventory inventory = inventoryService.getById(inventoryId);

        if(inventory.getDealer().getDealerId() != dealerId)
            return null;

        Set<InventoryUnit> inventoryUnits = inventoryService.getById(inventoryId).getInventoryUnits();
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",new ArrayList<InventoryUnit>(inventoryUnits));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody ResponseDTO insert(@RequestBody @Valid InventoryUnit inventoryUnit, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        inventoryUnitService.insert(inventoryUnit);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody ResponseDTO delete(@RequestParam("unit_id") int unit_id,
                                       @RequestParam("inventory_id") int inventory_id){
        Unit unit = unitService.getById(unit_id);
        Inventory inventory = inventoryService.getById(inventory_id);
        InventoryUnitId inventoryUnitId = new InventoryUnitId(inventory, unit);
        try {
            inventoryUnitService.delete(inventoryUnitId);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid InventoryUnit inventoryUnit,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        inventoryUnitService.update(inventoryUnit);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }
}