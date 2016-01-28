package com.gem.nhom1.controller;

import com.gem.nhom1.model.Bill;
import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.Customer;
import com.gem.nhom1.model.ResponseDTO;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.CustomerService;
import com.gem.nhom1.util.Constant;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private Validator validator;

    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public @ResponseBody
    ResponseDTO insert(@RequestBody Customer customer) {

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        if(constraintViolations.size() > 0) {
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR, constraintViolations.iterator().next().getMessage() , null  );
        }

        try {
            customerService.insert(customer);
        } catch (Exception e){
            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }


    @RequestMapping(value = "/update" ,   method = RequestMethod.PUT)
    public @ResponseBody ResponseDTO update(@RequestBody Customer customer) {

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        if(constraintViolations.size() > 0) {
            HttpHeaders httpHeaders =new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());
            return new ResponseDTO(Constant.RESPONSE_STATUS_ERROR ,constraintViolations.iterator().next().getMessage() ,null);

        }

        try {
            customerService.update(customer);
        } catch (Exception e){
            return  new ResponseDTO(Constant.RESPONSE_STATUS_ERROR , e.getMessage() , null);
        }

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
    public @ResponseBody ResponseDTO list(@RequestParam(value = "page" , defaultValue = "1") int page){
        List<Customer> customers= customerService.getList(page);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , customers);
    }

    @RequestMapping("/detail/{customerId}")
    public @ResponseBody ResponseDTO detailById(@PathVariable("customerId") int customerId){
        Customer customer = customerService.getById(customerId);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , customer);
    }

    @RequestMapping("/getListBill/{customerId}")
    public @ResponseBody ResponseDTO getListBill(@PathVariable("customerId") int customerId){

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" ,  customerService.getListBill(customerId));
    }

    @RequestMapping("billDetail/{billId}")
    public  @ResponseBody ResponseDTO billDetail(@PathVariable("billId") int billId) {

        Bill bill = billService.getById(billId);
        return new ResponseDTO( Constant.RESPONSE_STATUS_SUSSCESS , "" , bill);
    }

    @RequestMapping("/listBillDetail/{billId}")
    public @ResponseBody ResponseDTO query(@PathVariable("billId") int billId){
        List<BillDetail> billDetails= billService.getListBillDetail(billId);

        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , billDetails);

    }




}
