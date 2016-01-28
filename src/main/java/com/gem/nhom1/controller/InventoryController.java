package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.model.InventoryUnit;
import com.gem.nhom1.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    public @ResponseBody String insert(ModelMap modelMap){
        Inventory inventory = new Inventory("Ha noi", "Ha noi");
        int id = inventoryService.insert(inventory);
        return "Success";
    }

    @RequestMapping("/all")
    public @ResponseBody List<Inventory> getList(@RequestParam(value = "page") int page){
        List<Inventory> inventories = inventoryService.getList(page);
        int size = inventories.size();

        return inventories;
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String delete(ModelMap modelMap, @PathVariable int id){
        try {
            inventoryService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Success";
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String update(ModelMap modelMap, @PathVariable int id){
        Inventory inventory = inventoryService.getById(id);
        inventory.setAddress("Ha noi");
        inventoryService.update(inventory);
        return "Success";
    }

    @RequestMapping("/{id}")
    public @ResponseBody String getitem(ModelMap modelMap, @PathVariable int id){
        Inventory inventory = inventoryService.getById(id);
        Dealer dealer = inventory.getDealer();

        List<InventoryUnit> inventoryUnit = new ArrayList<InventoryUnit>(inventory.getInventoryUnits());

        return "Success";
    }

}
