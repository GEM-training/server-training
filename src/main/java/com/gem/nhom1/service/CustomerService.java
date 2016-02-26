package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.model.entities.Customer;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
public interface CustomerService {
    Customer getById(int id);
    List<Customer> getList(int startIndex);
    int insert(Customer customer);
    void delete(int customerId) throws Exception;
    void update(Customer customer);

    List<Bill> getListBill(int customerId);
}
