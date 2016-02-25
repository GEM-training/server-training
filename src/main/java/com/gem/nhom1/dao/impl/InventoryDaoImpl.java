package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.InventoryDao;
import com.gem.nhom1.model.entities.Inventory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nghicv on 21/01/2016.
 */

@Repository
public class InventoryDaoImpl extends AbstractDao<Integer, Inventory> implements InventoryDao {

    @Autowired
    private Constant constant;

    public int insert(Inventory inventory){
        return insertObject(inventory);
    }

    public List<Inventory> getList(int startIndex) {
        Query query = getSession().createQuery("from  Inventory i where  i.inventoryId > :startIndex order by i.inventoryId asc" );
        query.setParameter("startIndex" , startIndex);
        query.setMaxResults(constant.getMaxPageSize());
        return query.list();
    }

    public Inventory getById(int id) {
        return getByKey(id);
    }

    public void delete(int id) throws Exception {
        deleteObject(getById(id));
    }

    public void update(Inventory inventory){
        updateObject(inventory);
    }
}
