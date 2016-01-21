package com.gem.nhom1.service;

import com.gem.nhom1.model.BillDetail;

/**
 * Created by vanhop on 1/20/16.
 */
public interface BillDetailService {

    public void save(BillDetail billDetail);
    public BillDetail getBillDetailById(int id);

}
