package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.service.BillService;
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
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO insert(@RequestBody @Valid Bill bill, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        billService.insert(bill);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }


    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid Bill bill,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException  {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        billService.update(bill);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO list(@RequestParam(value = "start" , defaultValue = "1") int start) {

        List<Bill> bills = billService.getList(start);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , bills);
    }

    @RequestMapping("delete/{billId}")
    public @ResponseBody ResponseDTO delete(@PathVariable("billId") int billId) {

        try {
            billService.delete(billId);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }



}
