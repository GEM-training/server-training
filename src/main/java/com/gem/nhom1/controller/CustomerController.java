package com.gem.nhom1.controller;

import com.gem.nhom1.model.Bill;
import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.Customer;
import com.gem.nhom1.service.BillService;
import com.gem.nhom1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
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
    private javax.validation.Validator validator;

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/insert")
    public @ResponseBody String insert() {

        Customer customer = new Customer("Nguyen Van A", null, "Ha Noi");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        if(constraintViolations.size() > 0)
            return constraintViolations.iterator().next().getMessage();

        customerService.insert(customer);

        return "Success";
    }


    @RequestMapping("/update/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id) {

        Customer customer = customerService.getById(id);
        customer.setAddress(customer.getAddress() + " " + customer.getAddress());
        customerService.update(customer);

        return "Success";
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
    public @ResponseBody List<Customer> detail(){
        List<Customer> customers= customerService.getList();

        return customers;
    }

    @RequestMapping("/detail/{customerId}")
    public @ResponseBody Customer detail(@PathVariable("customerId") int customerId){
        Customer customer = customerService.getById(customerId);

        return customer;
    }

    @RequestMapping("/getListBill/{customerId}")
    public @ResponseBody List<Bill> getListBill(@PathVariable("customerId") int customerId){
        Customer customer = customerService.getById(customerId);

        return customerService.getListBill(customerId);
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
