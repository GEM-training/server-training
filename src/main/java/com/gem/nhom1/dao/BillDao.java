package com.gem.nhom1.dao;

import com.gem.nhom1.model.Bill;
import com.gem.nhom1.model.Dealer;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
public interface BillDao {
    public Bill getById(int id);
    public List<Bill> getList(int page);
    public int insert(Bill bill);
    public boolean delete(int billId);
    public void update(Bill bill);
}
