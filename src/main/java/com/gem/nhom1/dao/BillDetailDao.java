package com.gem.nhom1.dao;

import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.BillDetailId;
import com.gem.nhom1.model.Dealer;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
public interface BillDetailDao {

    public BillDetail getById(BillDetailId id);
    public List<BillDetail> getList(int page);
    public BillDetailId insert(BillDetail billDetail);
    public void delete(BillDetailId id) throws Exception;
    public void update(BillDetail billDetail);

}
