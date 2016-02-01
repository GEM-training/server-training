package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.CustomerDao;
import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.model.entities.Customer;
import com.gem.nhom1.service.CustomerService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    public Customer getById(int id) {
        return customerDao.getById(id);
    }

    public List<Customer> getList(int startIndex) {
        return customerDao.getList( startIndex);
    }

    public int insert(Customer customer){
        return customerDao.insert(customer);
    }

    public void delete(int customerId) throws Exception {
        customerDao.delete(customerId);
    }

    public void update(Customer customer){
        customerDao.update(customer);
    }

    public List<Bill> getListBill(int customerId) {
        Customer customer = getById(customerId);
        Hibernate.initialize(customer.getBills());

        return  new ArrayList<Bill>(customer.getBills());
    }
}
