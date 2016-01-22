package com.gem.nhom1.controller;

import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.model.InventoryUnit;
import com.gem.nhom1.model.InventoryUnitId;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.InventoryService;
import com.gem.nhom1.service.InventoryUnitService;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/item")
    public @ResponseBody String getInventoryUnit(ModelMap model,  @RequestParam("unit_id") int unit_id,
                                                 @RequestParam("inventory_id") int inventory_id){
        Unit unit = unitService.getById(unit_id);
        Inventory inventory = inventoryService.getById(inventory_id);
        InventoryUnitId inventoryUnitId = new InventoryUnitId(inventory, unit);
        InventoryUnit inventoryUnit = inventoryUnitService.getById(inventoryUnitId);

        return "success";
    }

    @RequestMapping("/all")
    public @ResponseBody String getList(ModelMap modelMap){

        List<InventoryUnit> inventoryUnits = inventoryUnitService.getList();
        return "success";
    }

    @RequestMapping("/insert")
    public @ResponseBody String inSert(ModelMap model, @RequestParam("unit_id") int unit_id,
                                       @RequestParam("inventory_id") int inventory_id){
        Unit unit = unitService.getById(unit_id);
        Inventory inventory = inventoryService.getById(inventory_id);

        InventoryUnitId inventoryUnitId = new InventoryUnitId(inventory, unit);
        InventoryUnit inventoryUnit = new InventoryUnit(inventoryUnitId, 200);
        inventoryUnitService.insert(inventoryUnit);

        return "success";
    }

    @RequestMapping("/delete")
    public @ResponseBody String delete(ModelMap model, @RequestParam("unit_id") int unit_id,
                                       @RequestParam("inventory_id") int inventory_id){
        Unit unit = unitService.getById(unit_id);
        Inventory inventory = inventoryService.getById(inventory_id);
        InventoryUnitId inventoryUnitId = new InventoryUnitId(inventory, unit);
        boolean deleted = inventoryUnitService.delete(inventoryUnitId);

        return "success";
    }

    @RequestMapping("update")
    public @ResponseBody String update(ModelMap model, @RequestParam("unit_id") int unit_id,
                                       @RequestParam("inventory_id") int inventory_id){
        Unit unit = unitService.getById(unit_id);
        Inventory inventory = inventoryService.getById(inventory_id);
        InventoryUnitId inventoryUnitId = new InventoryUnitId(inventory, unit);
        InventoryUnit inventoryUnit = inventoryUnitService.getById(inventoryUnitId);
        inventoryUnit.setQuantityInStock(89);
        inventoryUnitService.update(inventoryUnit);
        return "success";
    }
}
