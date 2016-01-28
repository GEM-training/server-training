package com.gem.nhom1.controller;

import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public ResponseEntity<?> insert(@RequestBody Staff staff) {
        //chi co dealer moi co the them staff, dealer dc luu trong session --spring security
        Dealer dealer = dealerService.getById(1);
        staff.setDealer(dealer);

        Set<ConstraintViolation<Staff>> constraintViolations = validator.validate(staff);

        if (constraintViolations.size() > 0) {
            return new ResponseEntity<String>(constraintViolations.iterator().next().getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
        staffService.insert(staff);

        return new ResponseEntity<Staff>(staff, HttpStatus.OK);

    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Staff> query(@PathVariable("id") Integer id) {
        Staff staff = staffService.getById(id);
        int i = HibernateConfiguration.pageSize;
        return new ResponseEntity<Staff>(staff, HttpStatus.OK);
    }

    @RequestMapping("/query/all")
    public ResponseEntity<List<Staff>> queryAll() {
        List<Staff> staffList = staffService.getList();
        return new ResponseEntity<List<Staff>>(staffList, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Staff staff) {

        Set<ConstraintViolation<Staff>> constraintViolations = validator.validate(staff);

        if (constraintViolations.size() > 0) {
            return new ResponseEntity<String>(constraintViolations.iterator().next().getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
        staffService.update(staff);

        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

        try {
            staffService.delete(id);
        } catch (Exception e){
            return new ResponseEntity<Exception>(e,HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
