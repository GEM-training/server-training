package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.DealerDao;
import com.gem.nhom1.model.Dealer;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Repository
public class DealerDaoImpl extends AbstractDao<Integer , Dealer> implements DealerDao {

    public Dealer getById(int id) {
        return getByKey(id);
    }

    public List<Dealer> getList() {
        return getSession().createQuery("from Dealer").list();
    }

    public int insert(Dealer dealer) {
        return insertObject(dealer);
    }

    public boolean delete(int dealerId) {
        try{
            deleteObject(getByKey(dealerId));
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public void update(Dealer dealer) {
        updateObject(dealer);
    }
}
