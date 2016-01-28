package com.gem.nhom1.controller;

import com.gem.nhom1.model.Unit;
import com.gem.nhom1.model.UnitDealer;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * Created by phuongtd on 21/01/2016.
 */
@Controller
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping("/insert")
    public @ResponseBody String insert(){

        Unit unit = new Unit("Xe Dap", 0);
        unitService.insert(unit);

        //Unit unit1 = unitService.getById(1);
        Unit newUnit = new Unit("Oc Vit", 1, unit);

        unitService.insert(newUnit);
        return "Success";
    }

    @RequestMapping(value = "/query/{id}")
    public @ResponseBody String query(@PathVariable("id") Integer id){

        Unit unit = unitService.getById(id);
        Set<UnitDealer> dealerSet = unit.getUnitDealers();
        Set<Unit> unitSet = unit.getUnits();
        return "Success";
    }

    @RequestMapping("/query/all/{page}")
    public @ResponseBody String queryAll(@PathVariable (value = "page") int page){

        List<Unit> unitList = unitService.getList(page);

        return "Success";
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id){
        Unit unit = unitService.getById(id);
        unit.setType(unit.getType() + " 2");
        unitService.update(unit);
        return "Success";
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id){
        unitService.delete(id);
        return "Success";
    }


}
