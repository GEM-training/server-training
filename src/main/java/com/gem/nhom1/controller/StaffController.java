package com.gem.nhom1.controller;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.ResponseDTO;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.StaffService;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private DealerService dealerService;
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody ResponseDTO insert(@RequestBody Staff staff) {
        //chi co dealer moi co the them staff, dealer dc luu trong session --spring security
        Dealer dealer = dealerService.getById(1);
        staff.setDealer(dealer);

        Set<ConstraintViolation<Staff>> constraintViolations = validator.validate(staff);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(),null);
        }

        try {
            staffService.insert(staff);
        }catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",null);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseDTO query(@PathVariable("id") Integer id) {
        Staff staff = staffService.getById(id);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",staff);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO queryAll(@RequestParam(value = "page" , defaultValue = "1")  int page) {
        List<Staff> staffList = staffService.getList(page);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS,"",staffList);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody Staff staff) {

        Set<ConstraintViolation<Staff>> constraintViolations = validator.validate(staff);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(),null);
        }

        try {
            staffService.update(staff);
        }catch (Exception e){
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(),null);
        }

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
