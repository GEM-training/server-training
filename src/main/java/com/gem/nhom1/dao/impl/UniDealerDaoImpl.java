package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.UnitDealerDao;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.model.UnitDealer;
import com.gem.nhom1.model.UnitDealerId;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vanhop on 1/21/16.
 */
@Repository
public class UniDealerDaoImpl extends AbstractDao<UnitDealerId, UnitDealer> implements UnitDealerDao {
    public UnitDealer getById(UnitDealerId id) {
        return getByKey(id);
    }

    public List<UnitDealer> getList() {
        return getSession().createQuery("from " + UnitDealer.class).list();
    }

    public UnitDealerId insert(UnitDealer unitDealer){
        return insertObject(unitDealer);
    }

    public void delete(UnitDealerId id) throws Exception {
        UnitDealer unitDealer = getByKey(id);
        deleteObject(unitDealer);
    }

    public void update(UnitDealer unitDealer){
        updateObject(unitDealer);
    }
}
