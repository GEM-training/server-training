package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Bill;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
public interface BillDao {
    Bill getById(int id);
    List<Bill> getList(int startIndex);
    int insert(Bill bill);
    void delete(int billId) throws Exception;
    void update(Bill bill);
}
