package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Inventory;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
interface InventoryDao {
    int insert(Inventory inventory);
    List<Inventory> getList(int startIndex);
    Inventory getById(int id);
    void delete(int id) throws Exception;
    void update(Inventory inventory);

}
