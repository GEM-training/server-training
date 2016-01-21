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
        return null;
    }

    public List<Dealer> getList() {
        return null;
    }

    public boolean delete(int dealerId) {
        return false;
    }
}
