package com.gem.nhom1.controller;

import com.gem.nhom1.model.*;
import com.gem.nhom1.service.*;
import com.gem.nhom1.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * Created by phuong on 1/19/2016.
 */
@Controller
@RequestMapping("/dealer")
public class DealerController {

    @Autowired
    private BillDetailService billDetailService;

    @Autowired
    private UnitDealerService unitDealerService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private DealerService dealerService;

    @Autowired
    private BillService billService;
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody  ResponseDTO insert(@RequestBody Dealer dealer) {
        Set<ConstraintViolation<Dealer>> constraintViolations = validator.validate(dealer);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(),null);
        }
        dealerService.insert(dealer);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody Dealer dealer) {
        Set<ConstraintViolation<Dealer>> constraintViolations = validator.validate(dealer);

        if (constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR,constraintViolations.iterator().next().getMessage(), null);
        }
        dealerService.update(dealer);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO list(@RequestParam(value = "page", defaultValue = "1") int page) {
        List<Dealer> list = dealerService.getList(page);

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
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS, "", null);
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
    public @ResponseBody ResponseDTO getListUnitDealers(@PathVariable("dealerId") int dealerId) {
        List<UnitDealer> unitDealers = dealerService.getListUnitDealer(dealerId);

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

}
