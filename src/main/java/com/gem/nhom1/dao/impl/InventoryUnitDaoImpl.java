package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.InventoryUnitDao;
import com.gem.nhom1.model.entities.InventoryUnit;
import com.gem.nhom1.model.entities.InventoryUnitId;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
@Repository
public class InventoryUnitDaoImpl extends AbstractDao<InventoryUnitId, InventoryUnit> implements InventoryUnitDao {

    @Autowired
    private Constant constant;

    public InventoryUnitId insert(InventoryUnit inventoryUnit){
        return insertObject(inventoryUnit);
    }

    public List<InventoryUnit> getList(int page) {
        Query query = getSession().createQuery("from InventoryUnit");
        query.setFirstResult((page - 1) * constant.getMaxPageSize());
        query.setMaxResults(constant.getMaxPageSize());

        return query.list();
    }


    public InventoryUnit getById(InventoryUnitId inventoryUnitId) {
        return getByKey(inventoryUnitId);
    }


    public void delete(InventoryUnitId inventoryUnitId) throws Exception {
        deleteObject(getByKey(inventoryUnitId));
    }

    public void update(InventoryUnit inventoryUnit){
        updateObject(inventoryUnit);
    }
}
