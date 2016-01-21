package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.CustomerDao;
import com.gem.nhom1.dao.UnitDao;
import com.gem.nhom1.model.Customer;
import com.gem.nhom1.model.Unit;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 * Created by vanhop on 1/18/16.
 */
@Repository
public class CustomerDaoImpl extends AbstractDao<Integer,Customer> implements CustomerDao {

    public void save(Customer customer){
        persist(customer);
    }

    public Customer getCustomerById(int id) {

        Customer customer = getByKey(id);

        return customer;

    }

}
