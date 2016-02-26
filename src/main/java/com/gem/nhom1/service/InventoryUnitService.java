package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.InventoryUnit;
import com.gem.nhom1.model.entities.InventoryUnitId;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
public interface InventoryUnitService {
    InventoryUnitId insert(InventoryUnit inventoryUnit);
    List<InventoryUnit> getList(int page);

    InventoryUnit getById(InventoryUnitId inventoryUnitId);
    void delete(InventoryUnitId inventoryUnitId) throws Exception;
    void update(InventoryUnit inventoryUnit);

}
