package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Bill;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
public interface BillDao {
    public Bill getById(int id);
    public List<Bill> getList(int startIndex);
    public int insert(Bill bill);
    public void delete(int billId) throws Exception;
    public void update(Bill bill);
}
