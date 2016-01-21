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
    public Bill getBillById(int id) {
        Bill bill = getByKey(id);
        Hibernate.initialize(bill.getBillDetail());
        return bill;
    }

    public void save(Bill bill) {
        persist(bill);
    }

    public List<Bill> getListBill() {
        return getSession().createQuery("FROM Bill").list();
    }

    public void deleteBill(int billId) {
        Bill bill = getByKey(billId);
        delete(bill);
    }

    public void update(Bill bill) {
        getSession().saveOrUpdate(bill);
    }

    public int insertBill(Bill bill) {
        return insert(bill);
    }
}
