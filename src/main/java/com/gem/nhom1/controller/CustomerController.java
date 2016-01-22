package com.gem.nhom1.controller;

import com.gem.nhom1.model.Customer;
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

    @RequestMapping(value = "/insert", produces = "text/html; charset=utf-8")
    public @ResponseBody String insert() {

        Customer customer = new Customer("Nguyen Van A", null, "Ha Noi");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        if(constraintViolations.size() > 0)
            return constraintViolations.iterator().next().getMessage();

        customerService.insert(customer);

        return "Success";
    }

    @RequestMapping("/query/{id}")
    public
    @ResponseBody
    String query(@PathVariable("id") Integer id) {

        Customer customer = customerService.getById(id);

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

        customerService.delete(id);

        return "Success";
    }


}
