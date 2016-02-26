package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.BillDao;
import com.gem.nhom1.model.entities.Bill;
import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.service.BillService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
@Service
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillDao billDao;

    public Bill getById(int id) {
        return billDao.getById(id);
    }

    public List<Bill> getList(int startIndex) {
        return billDao.getList(startIndex);
    }

    public int insert(Bill bill){
        return billDao.insert(bill);
    }

    public void delete(int billId) throws Exception {
        billDao.delete(billId);
    }

    public void update(Bill bill){
        billDao.update(bill);
    }

    public List<BillDetail> getListBillDetail(int billId){
        Bill bill = getById(billId);
        Hibernate.initialize(bill.getBillDetail());
        return new ArrayList<BillDetail>(bill.getBillDetail());
    }
}
