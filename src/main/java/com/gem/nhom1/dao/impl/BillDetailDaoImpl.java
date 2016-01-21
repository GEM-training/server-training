package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.BillDetailDao;
import com.gem.nhom1.model.BillDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vanhop on 1/20/16.
 */
@Repository
@Transactional
public class BillDetailDaoImpl extends AbstractDao<Integer,BillDetail> implements BillDetailDao {
    public void save(BillDetail billDetail) {
        persist(billDetail);
    }

    public BillDetail getBillDetailById(int id) {
        return getByKey(id);
    }
}
