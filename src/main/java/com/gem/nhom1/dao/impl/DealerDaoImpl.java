package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.DealerDao;
import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.model.Unit;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Repository
public class DealerDaoImpl extends AbstractDao<Integer, Dealer> implements DealerDao {

    public Dealer getById(int id) {
        return getByKey(id);
    }

    public List<Dealer> getList(int page) {
        Query query =  getSession().createQuery("from Dealer");
        query.setFirstResult((page - 1) * HibernateConfiguration.pageSize);
        query.setMaxResults(HibernateConfiguration.pageSize);

        return query.list();
    }

    public int insert(Dealer dealer){
        return insertObject(dealer);
    }

    public void delete(int dealerId) throws Exception {
        deleteObject(getByKey(dealerId));
    }

    public void update(Dealer dealer){
        updateObject(dealer);
    }

}
