package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.BillDetailDao;
import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.model.entities.BillDetailId;
import com.gem.nhom1.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vanhop on 1/20/16.
 */
@Service
@Transactional
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    private BillDetailDao billDetailDao;

    public BillDetail getById(BillDetailId id) {
        return billDetailDao.getById(id);
    }

    public BillDetailId insert(BillDetail billDetail) {
        return billDetailDao.insert(billDetail);
    }

    public void delete(BillDetailId id) throws Exception {
        billDetailDao.delete(id);
    }

    public void update(BillDetail billDetail) {

        billDetailDao.update(billDetail);
    }
}
