package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.BillDao;
import com.gem.nhom1.model.Bill;
import com.gem.nhom1.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
@Service
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillDao billDao;

    public Bill getBillById(int id) {
        return billDao.getBillById(id);
    }

    public void save(Bill bill) {
        billDao.save(bill);
    }

    public List<Bill> getListBill() {
        return billDao.getListBill();
    }

    public void update(Bill bill) {
        billDao.update(bill);
    }

    public int insertBill(Bill bill) {
        return billDao.insertBill(bill);
    }
}
