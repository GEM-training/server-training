package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.InventoryService;
import com.gem.nhom1.service.InventoryUnitService;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
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

/*    @RequestMapping("/query/unit/{unit_id}/inventory/{inventory_id}")
    public @ResponseBody InventoryUnit getInventoryUnit(@PathVariable("unit_id") int unit_id,
                                                 @PathVariable("inventory_id") int inventory_id){
        Unit unit = unitService.getById(unit_id);
        Inventory inventory = inventoryService.getById(inventory_id);
        InventoryUnitId inventoryUnitId = new InventoryUnitId(inventory, unit);
        InventoryUnit inventoryUnit = inventoryUnitService.getById(inventoryUnitId);

        return inventoryUnit;
    }*/

    @RequestMapping("/inventory/{inventory_id}/dealer/{dealer_id}")
    public @ResponseBody Set<InventoryUnit> getList(@PathVariable("dealer_id") Integer dealerId, @PathVariable("inventory_id") Integer inventoryId){

        Dealer dealer = dealerService.getById(dealerId);

        Inventory inventory = inventoryService.getById(inventoryId);

        if(inventory.getDealer().getDealerId() != dealerId)
            return null;

        Set<InventoryUnit> inventoryUnits = inventoryService.getById(inventoryId).getInventoryUnits();
        return inventoryUnits;
    }

    @RequestMapping("/insert")
    public @ResponseBody String insert(HttpSession session, @RequestParam("unit_id") int unit_id,
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
