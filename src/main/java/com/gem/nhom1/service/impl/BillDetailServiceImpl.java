package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.BillDetailDao;
import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.BillDetailId;
import com.gem.nhom1.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
@Service
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    private BillDetailDao billDetailDao;

    public BillDetail getById(BillDetailId id) {
        return billDetailDao.getById(id);
    }

    public List<BillDetail> getList() {
        return billDetailDao.getList();
    }

    public BillDetailId insert(BillDetail billDetail) {
        return billDetailDao.insert(billDetail);
    }

    public boolean delete(BillDetailId id) {
        return billDetailDao.delete(id);
    }

    public void update(BillDetail billDetail) {
        billDetailDao.update(billDetail);
    }
}
