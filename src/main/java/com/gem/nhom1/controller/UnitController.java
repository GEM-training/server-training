package com.gem.nhom1.controller;

import com.gem.nhom1.model.ResponseDTO;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.model.UnitDealer;
import com.gem.nhom1.service.UnitService;
import com.gem.nhom1.util.Constant;
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
    public @ResponseBody ResponseDTO insert(@RequestBody Unit unit){

        Set<ConstraintViolation<Unit>> constraintViolations = validator.validate(unit);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(),null);
        }

        try {
            unitService.insert(unit);
        }catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseDTO query(@PathVariable("id") Integer id){

        Unit unit = unitService.getById(id);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",unit);
    }

    @RequestMapping("/query/all")
    public @ResponseBody ResponseDTO queryAll(@RequestParam (value = "page", defaultValue = "1") int page){

        List<Unit> unitList = unitService.getList(page);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",unitList);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody Unit unit){

        Set<ConstraintViolation<Unit>> constraintViolations = validator.validate(unit);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(), null);
        }

        try {
            unitService.update(unit);
        }catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(), null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseDTO delete(@PathVariable("id") Integer id){
        try {
            unitService.delete(id);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }


}
