package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.BillDao;
import com.gem.nhom1.model.Bill;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
@Repository
public class BillDaoImpl extends AbstractDao<Integer , Bill> implements BillDao {
    public Bill getById(int id) {
        return getByKey(id);
    }

    public List<Bill> getList() {
        return getSession().createQuery("from Bill").list();
    }

    public int insert(Bill bill) {
        return insertObject(bill);
    }

    public boolean delete(int billId) {
        try {
            deleteObject(getByKey(billId));
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public void update(Bill bill) {
        updateObject(bill);
    }
}
