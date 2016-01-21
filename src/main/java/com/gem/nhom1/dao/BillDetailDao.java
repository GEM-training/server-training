package com.gem.nhom1.dao;

import com.gem.nhom1.model.BillDetail;

/**
 * Created by vanhop on 1/20/16.
 */
public interface BillDetailDao {

    public void save(BillDetail billDetail);
    public BillDetail getBillDetailById(int id);

}
