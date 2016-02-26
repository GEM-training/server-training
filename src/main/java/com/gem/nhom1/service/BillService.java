package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.model.entities.BillDetail;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
public interface BillService {
    Bill getById(int id);
    List<Bill> getList(int startIndex);
    int insert(Bill bill);
    void delete(int billId) throws Exception;
    void update(Bill bill);

    List<BillDetail> getListBillDetail(int billId);

}
