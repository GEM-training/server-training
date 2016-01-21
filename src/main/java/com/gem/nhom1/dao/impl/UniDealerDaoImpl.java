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
public class UniDealerDaoImpl extends AbstractDao<UnitDealerId,UnitDealer> implements UnitDealerDao {
    public UnitDealer getById(UnitDealerId id) {
       // String SQL = "select * from dealer_unit ud where ud.unit_id = :unitId and ud.delaer_id = :dealerId";

       // return getSession().createSQLQuery(SQL);
        return getByKey(id);
    }

    public List<UnitDealer> getList() {
        return getSession().createQuery("from " + UnitDealer.class).list();
    }

    public UnitDealerId insert(UnitDealer unitDealer) {
        return insertObject(unitDealer);
    }

    public boolean delete(UnitDealerId id) {
        return false;
    }

    public void update(UnitDealer unitDealer) {
        updateObject(unitDealer);
    }
}
