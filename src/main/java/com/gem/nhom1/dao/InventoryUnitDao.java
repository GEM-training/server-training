package com.gem.nhom1.dao;

import com.gem.nhom1.model.InventoryUnit;
import com.gem.nhom1.model.InventoryUnitId;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
public interface InventoryUnitDao {

    public InventoryUnitId insert(InventoryUnit inventoryUnit);
    public List<InventoryUnit> getList(int page);
    public InventoryUnit getById(InventoryUnitId inventoryUnitId);
    public boolean delete(InventoryUnitId inventoryUnitId);
    public void update(InventoryUnit inventoryUnit);
}
