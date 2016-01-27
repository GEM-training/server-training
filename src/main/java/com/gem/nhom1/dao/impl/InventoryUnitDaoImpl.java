package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.InventoryUnitDao;
import com.gem.nhom1.model.InventoryUnit;
import com.gem.nhom1.model.InventoryUnitId;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
@Repository
public class InventoryUnitDaoImpl extends AbstractDao<InventoryUnitId, InventoryUnit> implements InventoryUnitDao {

    public InventoryUnitId insert(InventoryUnit inventoryUnit){
        return insertObject(inventoryUnit);
    }

    public List<InventoryUnit> getList() {
        return null;
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
