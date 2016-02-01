package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.Staff;
import com.gem.nhom1.service.StaffService;
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
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody ResponseDTO insert(@RequestBody @Valid Staff staff, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        staffService.insert(staff);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseDTO query(@PathVariable("id") Integer id) {
        Staff staff = staffService.getById(id);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",staff);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO queryAll(@RequestParam(value = "start" , defaultValue = "1")  int start) {
        List<Staff> staffList = staffService.getList(start);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",staffList);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid Staff staff,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException  {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        staffService.update(staff);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseDTO delete(@PathVariable("id") Integer id) {

        try {
            staffService.delete(id);
        } catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);
    }
}
