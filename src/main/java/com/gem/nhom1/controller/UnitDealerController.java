package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.model.UnitDealer;
import com.gem.nhom1.model.UnitDealerId;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.UnitDealerService;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

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
    @Autowired
    protected Validator validator;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody UnitDealer unitDealer){

       /* Dealer dealer = dealerService.getById(1);
        Unit unit = unitService.getById(33);

        UnitDealer unitDealer = new UnitDealer(dealer,unit,2000);*/

        Set<ConstraintViolation<UnitDealer>> constraintViolations = validator.validate(unitDealer);

        if (constraintViolations.size() > 0) {
            return new ResponseEntity<String>(constraintViolations.iterator().next().getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

        unitDealerService.insert(unitDealer);

        return new ResponseEntity<UnitDealer>(unitDealer,HttpStatus.OK);
    }

    @RequestMapping("/query/unit-{unit_id}/dealer-{dealer_id}")
    public @ResponseBody String query(@PathVariable("unit_id") Integer unitId, @PathVariable("dealer_id") Integer dealerId){

        Unit unit = unitService.getById(unitId);
        Dealer dealer = dealerService.getById(dealerId);

        UnitDealer unitDealer = unitDealerService.getById(new UnitDealerId(unitId,dealerId));

        return "Success";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody UnitDealer unitDealer){

       // UnitDealer unitDealer = unitDealerService.getById(new UnitDealerId(unitId,dealerId));
        //unitDealer.setPrice(4000);
        Set<ConstraintViolation<UnitDealer>> constraintViolations = validator.validate(unitDealer);

        if (constraintViolations.size() > 0) {
            return new ResponseEntity<String>(constraintViolations.iterator().next().getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

        unitDealerService.update(unitDealer);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/unit-{unit_id}/dealer-{dealer_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("unit_id") Integer unitId, @PathVariable("dealer_id") Integer dealerId){

        try {
            unitDealerService.delete(new UnitDealerId(unitId,dealerId));
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e,HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
