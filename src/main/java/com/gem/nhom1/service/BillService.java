package com.gem.nhom1.service;

import com.gem.nhom1.model.Bill;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
public interface BillService {
    public Bill getById(int id);
    public List<Bill> getList();
    public int insert(Bill bill);
    public boolean delete(int billId);
    public void update(Bill bill);

}
