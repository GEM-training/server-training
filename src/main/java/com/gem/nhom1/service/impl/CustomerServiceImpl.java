package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.CustomerDao;
import com.gem.nhom1.model.Customer;
import com.gem.nhom1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vanhop on 1/18/16.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }
}
