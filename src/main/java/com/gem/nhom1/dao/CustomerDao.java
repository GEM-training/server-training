package com.gem.nhom1.dao;

import com.gem.nhom1.model.Customer;
import com.gem.nhom1.model.Unit;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
public interface CustomerDao {

    public void save(Customer customer);
<<<<<<< HEAD

    public List<Customer> getListCustomer();

=======
>>>>>>> e6af37389a8b16ff5c42ceac2631748ce1525c82
    public Customer getCustomerById(int id);
}
