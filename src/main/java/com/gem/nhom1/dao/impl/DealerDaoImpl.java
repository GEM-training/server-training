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
    public void save(Dealer dealer) {
        persist(dealer);
    }

    public List<Dealer> getListDealer() {
        return getSession().createQuery("from Dealer").list();
    }

    public Dealer getDealerById(int id) {
        Dealer d = getByKey(id);
        Hibernate.initialize(d.getInventorys());
        return d;
    }
}
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
    public void save(Dealer dealer) {
        persist(dealer);
    }

    public List<Dealer> getListDealer() {
        return getSession().createQuery("from Dealer").list();
    }

    public Dealer getDealerById(int id) {
        Dealer d = getByKey(id);
        Hibernate.initialize(d.getInventorys());
        return d;
    }
}
