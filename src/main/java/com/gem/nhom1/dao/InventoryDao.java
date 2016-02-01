package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Inventory;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
public interface InventoryDao {
    public int insert(Inventory inventory);
    public List<Inventory> getList(int startIndex);
    public Inventory getById(int id);
    public void delete(int id) throws Exception;
    public void update(Inventory inventory);

}
