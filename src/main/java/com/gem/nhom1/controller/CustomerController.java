package com.gem.nhom1.controller;

import com.gem.nhom1.exception.exception.ValidationException;
import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.model.entities.Customer;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillService billService;

    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public @ResponseBody ResponseDTO insert(@RequestBody @Valid Customer customer, BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        customerService.insert(customer);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }


    @RequestMapping(value = "/update" ,   method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody @Valid Customer customer,BindingResult bindingResult) throws SQLException,ValidationException,DataAccessException  {

        if (bindingResult.hasErrors())
            throw new ValidationException(bindingResult.getAllErrors().get(0).getDefaultMessage());

        customerService.update(customer);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody ResponseDTO delete(@PathVariable("id") Integer id){

        try {
            customerService.delete(id);
        } catch (Exception e) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }

    @RequestMapping("/list")
    public @ResponseBody ResponseDTO list(@RequestParam(value = "start" , defaultValue = "1") int start){
        List<Customer> customers= customerService.getList(start);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , customers);
    }

    @RequestMapping("/{customerId}")
    public @ResponseBody ResponseDTO detailById(@PathVariable("customerId") int customerId){
        Customer customer = customerService.getById(customerId);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , customer);
    }

    @RequestMapping("/bills/{customerId}")
    public @ResponseBody ResponseDTO getListBill(@PathVariable("customerId") int customerId){

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" ,  customerService.getListBill(customerId));
    }

    @RequestMapping("/bill/{billId}")
    public  @ResponseBody ResponseDTO billDetail(@PathVariable("billId") int billId) {

        Bill bill = billService.getById(billId);
        return new ResponseDTO( Constant.RESPONSE_STATUS_SUSSCESS , "" , bill);
    }

    @RequestMapping("/bill_details/{billId}")
    public @ResponseBody ResponseDTO query(@PathVariable("billId") int billId){
        List<BillDetail> billDetails= billService.getListBillDetail(billId);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , billDetails);

    }

}
