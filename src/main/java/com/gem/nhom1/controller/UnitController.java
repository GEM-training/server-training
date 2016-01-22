package com.gem.nhom1.controller;

import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

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

        Unit unit1 = unitService.getById(1);
        Unit newUnit = new Unit("Oc Vit", 1, unit1);

        unitService.insert(newUnit);
        return "Success";
    }

    @RequestMapping(value = "/query/{id}")
    public @ResponseBody Unit query(@PathVariable("id") Integer id){

        Unit unit = unitService.getById(id);
        Iterator<BillDetail> iterator = unit.getBillDetail().iterator();
        if(unit != null)
            return unit;

        return null;
    }

    @RequestMapping("/query/all")
    public @ResponseBody String queryAll(){
        return null;
    }

    @RequestMapping("/update/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id){
        return null;
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String delete(){
        return null;
    }


}
