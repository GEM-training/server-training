package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.model.entities.BillDetail;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
public interface BillService {
    public Bill getById(int id);
    public List<Bill> getList(int startIndex);
    public int insert(Bill bill);
    public void delete(int billId) throws Exception;
    public void update(Bill bill);

    public List<BillDetail> getListBillDetail(int billId);

}
