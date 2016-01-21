package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.InventoryUnitDao;
import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.model.InventoryUnit;
import com.gem.nhom1.model.InventoryUnitId;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
@Repository
public class InventoryUnitDaoImpl extends AbstractDao<Integer, InventoryUnit> implements InventoryUnitDao{

    public int insert(InventoryUnit inventoryUnit) {
        return 0;
    }

    public List<InventoryUnit> getList() {
        return null;
    }

    public Inventory getById(InventoryUnitId inventoryUnitId) {
        return null;
    }

    public boolean delete(InventoryUnitId inventoryUnitId) {
        return false;
    }

    public void update(InventoryUnit inventoryUnit) {

    }
}
