package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Customer;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
interface CustomerDao {

    Customer getById(int id);
    List<Customer> getList(int startIndex);
    int insert(Customer customer);
    void delete(int customerId) throws Exception;
    void update(Customer customer);

}
