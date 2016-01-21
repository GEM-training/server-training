package com.gem.nhom1.dao;

import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.model.InventoryUnit;
import com.gem.nhom1.model.InventoryUnitId;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
public interface InventoryUnitDao {

    public int insert(InventoryUnit inventoryUnit);
    public List<InventoryUnit> getList();
    public Inventory getById(InventoryUnitId inventoryUnitId);
    public boolean delete(InventoryUnitId inventoryUnitId);
    public void update(InventoryUnit inventoryUnit);
}
