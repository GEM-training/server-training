package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.InventoryDao;
import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.model.Promotion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */

@Repository
public class InventoryDaoImpl extends AbstractDao<Integer, Inventory> implements InventoryDao{
    public int insert(Inventory inventory) {
        return insertObject(inventory);
    }

    public List<Inventory> getList() {
        return getSession().createQuery("from Inventory").list();
    }

    public Inventory getById(int id) {
        return getByKey(id);
    }

    public boolean delete(int id) {

        try {
            deleteObject(getById(id));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void update(Inventory inventory) {
        updateObject(inventory);
    }
}
