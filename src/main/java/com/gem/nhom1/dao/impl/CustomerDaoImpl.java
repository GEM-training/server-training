package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.CustomerDao;
import com.gem.nhom1.model.entities.Customer;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
@Repository
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

    @Autowired
    private Constant constant;

    public Customer getById(int id) {
        return getByKey(id);
    }

    public List<Customer> getList(int startIndex) {
        Query query = getSession().createQuery("from  Customer c where  c.id > :startIndex order by c.id asc" );
        query.setParameter("startIndex" , startIndex);
        query.setMaxResults(constant.getMaxPageSize());
        return query.list();
    }

    public int insert(Customer customer){
        return insertObject(customer);
    }

    public void delete(int customerId) throws Exception {
        deleteObject(getByKey(customerId));
    }

    public void update(Customer customer){
        updateObject(customer);
    }
}
