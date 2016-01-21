package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.CustomerDao;
import com.gem.nhom1.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
@Repository
public class CustomerDaoImpl extends AbstractDao<Integer,Customer> implements CustomerDao {

    public void save(Customer customer){
        persist(customer);
    }

    public List<Customer> getListCustomer() {
        return null;
    }

    public Customer getCustomerById(int id) {

        Customer customer = getByKey(id);

        return customer;

    }

}
