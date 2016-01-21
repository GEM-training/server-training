package com.gem.nhom1.dao;

import com.gem.nhom1.model.Inventory;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
public interface InventoryDao {
    public void save(Inventory inventory);
    public List<Inventory> getListInventory();
    public void deleteInventory(int inventoryId);



}
