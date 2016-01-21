package com.gem.nhom1.dao;

import com.gem.nhom1.model.Customer;
import com.gem.nhom1.model.Unit;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
public interface CustomerDao {

    public void save(Customer customer);


    public List<Customer> getListCustomer();

    public Customer getCustomerById(int id);
}
