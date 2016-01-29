package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.InventoryUnitDao;
import com.gem.nhom1.model.entities.InventoryUnit;
import com.gem.nhom1.model.entities.InventoryUnitId;
import com.gem.nhom1.service.InventoryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */
@Service
@Transactional
public class InventoryUnitServiceImpl implements InventoryUnitService{

    @Autowired
    private InventoryUnitDao dao;

    public InventoryUnitId insert(InventoryUnit inventoryUnit){
        return dao.insert(inventoryUnit);
    }

    public List<InventoryUnit> getList(int page) {
        return dao.getList(page);
    }

    public InventoryUnit getById(InventoryUnitId inventoryUnitId) {
        return dao.getById(inventoryUnitId);
    }

    public void delete(InventoryUnitId inventoryUnitId) throws Exception {
        dao.delete(inventoryUnitId);
    }

    public void update(InventoryUnit inventoryUnit){
        dao.update(inventoryUnit);
    }
}
