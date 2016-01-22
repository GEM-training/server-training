package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.model.UnitDealer;
import com.gem.nhom1.model.UnitDealerId;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.UnitDealerService;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by phuongtd on 21/01/2016.
 */
@Controller
@RequestMapping("/unit_dealer")
public class UnitDealerController {

    @Autowired
    private UnitDealerService unitDealerService;
    @Autowired
    private DealerService dealerService;
    @Autowired
    private UnitService unitService;

    @RequestMapping("/insert")
    public @ResponseBody String insert(){

        Dealer dealer = dealerService.getById(1);
        Unit unit = unitService.getById(33);

        UnitDealer unitDealer = new UnitDealer(dealer,unit,2000);

        unitDealerService.insert(unitDealer);

        return "Success";
    }

    @RequestMapping("/query/unit-{unit_id}/dealer-{dealer_id}")
    public @ResponseBody String query(@PathVariable("unit_id") Integer unitId, @PathVariable("dealer_id") Integer dealerId){

        Unit unit = unitService.getById(unitId);
        Dealer dealer = dealerService.getById(dealerId);

        UnitDealer unitDealer = unitDealerService.getById(new UnitDealerId(unitId,dealerId));

        return "Success";
    }

    @RequestMapping("update/unit-{unit_id}/dealer-{dealer_id}")
    public @ResponseBody String update(@PathVariable("unit_id") Integer unitId, @PathVariable("dealer_id") Integer dealerId){

        UnitDealer unitDealer = unitDealerService.getById(new UnitDealerId(unitId,dealerId));
        unitDealer.setPrice(4000);
        unitDealerService.update(unitDealer);
        return "Success";
    }

    @RequestMapping("delete/unit-{unit_id}/dealer-{dealer_id}")
    public @ResponseBody String delete(@PathVariable("unit_id") Integer unitId, @PathVariable("dealer_id") Integer dealerId){

        return unitDealerService.delete(new UnitDealerId(unitId,dealerId)) + "";
    }

}
