package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.UnitDealerDao;
import com.gem.nhom1.model.entities.UnitDealer;
import com.gem.nhom1.model.entities.UnitDealerId;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanhop on 1/21/16.
 */
@Repository
public class UniDealerDaoImpl extends AbstractDao<UnitDealerId, UnitDealer> implements UnitDealerDao {

    @Autowired
    private Constant constant;

    public UnitDealer getById(UnitDealerId id) {
        return getByKey(id);
    }

    public List<UnitDealer> getList(int page) {
        //return getSession().createQuery("from " + UnitDealer.class).list();

        Query query = getSession().createQuery("from UnitDealer");
        query.setFirstResult((page - 1) * constant.getMaxPageSize());
        query.setMaxResults(constant.getMaxPageSize());

        return query.list();
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

    public List<UnitDealer> getListUnitOfDealerByDealerId(int dealerId, int startIndex, int pageSize) {
        List<UnitDealer> unitDealerList = new ArrayList<UnitDealer>();

        Query query = getSession().createQuery("from UnitDealer ud where ud.dealer.dealerId = :dealerId and ud.unit.id > :startIndex order by ud.unit.id");

        query.setParameter("dealerId" , dealerId);
        query.setParameter("startIndex" , startIndex);

        query.setMaxResults(pageSize);

        unitDealerList = query.list();


        return unitDealerList;
    }
}
