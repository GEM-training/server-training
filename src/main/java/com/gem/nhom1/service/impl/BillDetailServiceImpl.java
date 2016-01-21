package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.BillDetailDao;
import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vanhop on 1/20/16.
 */
@Service
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    private BillDetailDao billDetailDao;

    public void save(BillDetail billDetail) {
        billDetailDao.save(billDetail);
    }

    public BillDetail getBillDetailById(int id) {
        return billDetailDao.getBillDetailById(id);
    }
}
