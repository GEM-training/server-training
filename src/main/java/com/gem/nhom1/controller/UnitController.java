package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.Unit;
import com.gem.nhom1.service.UnitService;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by phuongtd on 21/01/2016.
 */
@Controller
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody ResponseDTO insert(@RequestBody @Valid Unit unit, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        unitService.insert(unit);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseDTO query(@PathVariable("id") Integer id){

        Unit unit = unitService.getById(id);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",unit);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO queryAll(@RequestParam (value = "start", defaultValue = "1") int start){

        List<Unit> unitList = unitService.getList(start);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",unitList);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid Unit unit,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        unitService.update(unit);

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

    @RequestMapping("/search/{key}")
    public @ResponseBody ResponseDTO search(@PathVariable("key") String key){

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , ""  , unitService.search(key));
    }


}
