package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.*;
import com.gem.nhom1.service.*;
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
 * Created by phuong on 1/19/2016.
 */
@Controller
@RequestMapping("/dealer")
public class DealerController {

    @Autowired
    private DealerService dealerService;
    @Autowired
    private BillService billService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO insert(@RequestBody @Valid Dealer dealer, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        dealerService.insert(dealer);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }



    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid Dealer dealer,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException  {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        dealerService.update(dealer);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO list(@RequestParam(value = "startIndex", defaultValue = "-1") int startIndex, @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        List<Dealer> list = dealerService.getList(startIndex,pageSize);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", list);
    }

    @RequestMapping("/delete/{dealerId}")
    public @ResponseBody ResponseDTO delete(@PathVariable("dealerId") int dealerId) {

        try {
            dealerService.delete(dealerId);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,e.getMessage(), null);
        }
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }


    @RequestMapping("/{dealerId}")
    public @ResponseBody ResponseDTO detail(@PathVariable("dealerId") int dealerId) {
        Dealer d = dealerService.getById(dealerId);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", d);
    }

    @RequestMapping("/inventorys/{dealerId}")
    public @ResponseBody ResponseDTO getListInventory(@PathVariable("dealerId") int dealerId) {
        List<Inventory> inventories = dealerService.getListInventory(dealerId);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", inventories);
    }

    @RequestMapping("/staffs/{dealerId}")
    public @ResponseBody ResponseDTO getListStaff(@PathVariable("dealerId") int dealerId) {
        List<Staff> staffs = dealerService.getListStaff(dealerId);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", staffs);
    }

    @RequestMapping("/units/{dealerId}")
    public @ResponseBody ResponseDTO getListUnitDealers(@PathVariable("dealerId") int dealerId , @RequestParam(value = "startIndex" , defaultValue = "0") int startIndex , @RequestParam(value = "pageSize" , defaultValue = "15") int pageSize) {
        List<UnitDealer> unitDealers = dealerService.getListUnitDealer(dealerId , startIndex , pageSize);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", unitDealers);
    }

    @RequestMapping("/bills/{dealerId}")
    public @ResponseBody ResponseDTO getListBill(@PathVariable("dealerId") int dealerId) {
        List<Bill> bills = dealerService.getListBill(dealerId);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", bills);
    }

    @RequestMapping("bill/{billId}")
    public @ResponseBody ResponseDTO billDetail(@PathVariable("billId") int billId) {
        Bill bill;

        bill = billService.getById(billId);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", bill);
    }

    @RequestMapping("/bill_details/{billId}")
    public @ResponseBody ResponseDTO query(@PathVariable("billId") int billId) {
        List<BillDetail> billDetails = billService.getListBillDetail(billId);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", billDetails);
    }

    @RequestMapping("/demo")
    public @ResponseBody String demo(){
        dealerService.demo();
        return "";
    }

}
