package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.UnitDao;
import com.gem.nhom1.model.Unit;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */

@Repository
public class UnitDaoImpl extends AbstractDao<Integer, Unit> implements UnitDao {

    public Unit getById(int id) {
        return getByKey(id);
    }

    public List<Unit> getList() {
        return getSession().createQuery("from " + Unit.class.getName()).list();
    }

    public int insert(Unit unit){
        return insertObject(unit);
    }

    public void delete(int id) throws Exception {
        deleteObject(getByKey(id));
    }

    public void update(Unit unit){
        updateObject(unit);
    }
}

