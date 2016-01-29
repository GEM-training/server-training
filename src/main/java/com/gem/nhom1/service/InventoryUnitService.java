package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.InventoryUnit;
import com.gem.nhom1.model.entities.InventoryUnitId;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
public interface InventoryUnitService {
    public InventoryUnitId insert(InventoryUnit inventoryUnit);
    public List<InventoryUnit> getList(int page);

    public InventoryUnit getById(InventoryUnitId inventoryUnitId);
    public void delete(InventoryUnitId inventoryUnitId) throws Exception;
    public void update(InventoryUnit inventoryUnit);

}
