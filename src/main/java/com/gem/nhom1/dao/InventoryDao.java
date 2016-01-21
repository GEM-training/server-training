package com.gem.nhom1.dao;

import com.gem.nhom1.model.Inventory;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
public interface InventoryDao {
    public int insert(Inventory inventory);
    public List<Inventory> getList();
    public Inventory getById(int id);
    public boolean delete(int id);
    public void update(Inventory inventory);

}
