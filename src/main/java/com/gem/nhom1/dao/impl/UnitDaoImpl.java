package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.UnitDao;
import com.gem.nhom1.model.Unit;
import org.springframework.stereotype.Repository;

/**
 * Created by vanhop on 1/18/16.
 */
@Repository
public class UnitDaoImpl extends AbstractDao<Integer,Unit> implements UnitDao {

    public void save(Unit unit){
        persist(unit);
    }

}
