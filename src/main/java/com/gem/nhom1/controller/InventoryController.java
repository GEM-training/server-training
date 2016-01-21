package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.service.InventoryService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody String getList(ModelMap modelMap){
        List<Inventory> inventories = inventoryService.getList();
        int size = inventories.size();
        return "Success";
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String delete(ModelMap modelMap, @PathVariable int id){
        boolean deleted = inventoryService.delete(id);

        return "Success";
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String update(ModelMap modelMap, @PathVariable int id){
        Inventory inventory = inventoryService.getById(id);
        inventory.setAddress("Ha noi");
        inventoryService.update(inventory);
        return "Success";
    }

    @RequestMapping("/item/{id}")
    public @ResponseBody String getitem(ModelMap modelMap, @PathVariable int id){
        Inventory inventory = inventoryService.getById(id);
        Dealer dealer = inventory.getDealer();
        return "Success";
    }

}
