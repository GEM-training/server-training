package com.gem.nhom1.controller;

import com.gem.nhom1.model.Bill;
import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.Customer;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.CustomerService;
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
    public ResponseEntity<?>  insert(@RequestBody Customer customer) {

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        if(constraintViolations.size() > 0) {
            HttpHeaders httpHeaders =new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());
            return new ResponseEntity<Void>(httpHeaders , HttpStatus.EXPECTATION_FAILED);

        }

        customerService.insert(customer);

        return new ResponseEntity<Customer>(customer , HttpStatus.OK);
    }


    @RequestMapping(value = "/update" ,   method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Customer customer) {

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        if(constraintViolations.size() > 0) {
            HttpHeaders httpHeaders =new HttpHeaders();
            httpHeaders.add("message" , constraintViolations.iterator().next().getMessage());
            return new ResponseEntity<Void>(httpHeaders , HttpStatus.EXPECTATION_FAILED);

        }

        customerService.update(customer);

        return new ResponseEntity<Customer>(customer , HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id){

        try {
            customerService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Success";
    }

    @RequestMapping("/list")
    public ResponseEntity<List<Customer>> list(@RequestParam(value = "page" , defaultValue = "1") int page){
        List<Customer> customers= customerService.getList(page);

        return new ResponseEntity<List<Customer>>(customers , HttpStatus.OK);
    }

    @RequestMapping("/detail/{customerId}")
    public ResponseEntity<Customer> detail(@PathVariable("customerId") int customerId){
        Customer customer = customerService.getById(customerId);

        return new ResponseEntity<Customer>(customer , HttpStatus.OK);
    }

    @RequestMapping("/getListBill/{customerId}")
    public ResponseEntity<List<Bill>> getListBill(@PathVariable("customerId") int customerId){
        Customer customer = customerService.getById(customerId);

        return new ResponseEntity<List<Bill>>(customerService.getListBill(customerId) ,HttpStatus.OK);
    }

    @RequestMapping("billDetail/{billId}")
    public  @ResponseBody Bill billDetail(@PathVariable("billId") int billId) {
        Bill bill;

        bill = billService.getById(billId);
        return bill;
    }

    @RequestMapping("/listBillDetail/{billId}")
    public @ResponseBody List<BillDetail> query(@PathVariable("billId") int billId){
        List<BillDetail> billDetails= billService.getListBillDetail(billId);

        return billDetails;

    }




}
