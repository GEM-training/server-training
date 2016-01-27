package com.gem.nhom1.controller;

import com.gem.nhom1.model.Staff;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.model.UnitDealer;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
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
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> insert(@RequestBody Unit unit){

        Set<ConstraintViolation<Unit>> constraintViolations = validator.validate(unit);

        if (constraintViolations.size() > 0) {
            return new ResponseEntity<String>(constraintViolations.iterator().next().getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

        unitService.insert(unit);

        return new ResponseEntity<Unit>(unit, HttpStatus.OK);
    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Unit> query(@PathVariable("id") Integer id){

        Unit unit = unitService.getById(id);
        return new ResponseEntity<Unit>(unit,HttpStatus.OK);
    }

    @RequestMapping(value = "/query/all", method = RequestMethod.GET)
    public ResponseEntity<List<Unit>> queryAll(){

        List<Unit> unitList = unitService.getList();

        return new ResponseEntity<List<Unit>>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Unit unit){

        Set<ConstraintViolation<Unit>> constraintViolations = validator.validate(unit);

        if (constraintViolations.size() > 0) {
            return new ResponseEntity<String>(constraintViolations.iterator().next().getMessage(), HttpStatus.EXPECTATION_FAILED);
        }

        unitService.update(unit);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        try {
            unitService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e,HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
