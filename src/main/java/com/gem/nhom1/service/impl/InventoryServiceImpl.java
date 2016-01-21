package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.InventoryDao;
import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao dao;
    public int insert(Inventory inventory) {
        return dao.insert(inventory);
    }

    public List<Inventory> getList() {
        return dao.getList();
    }

    public Inventory getById(int id) {
        return dao.getById(id);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public void update(Inventory inventory) {
        dao.update(inventory);
    }
}
