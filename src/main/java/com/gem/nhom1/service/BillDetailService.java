package com.gem.nhom1.service;

import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.BillDetailId;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
public interface BillDetailService {

    public BillDetail getById(BillDetailId id);
    public List<BillDetail> getList();
    public BillDetailId insert(BillDetail billDetail);
    public void delete(BillDetailId id) throws Exception;
    public void update(BillDetail billDetail);

}
