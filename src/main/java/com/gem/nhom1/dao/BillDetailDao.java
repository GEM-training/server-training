package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.model.entities.BillDetailId;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
interface BillDetailDao {

    BillDetail getById(BillDetailId id);
    List<BillDetail> getList(int page);
    BillDetailId insert(BillDetail billDetail);
    void delete(BillDetailId id) throws Exception;
    void update(BillDetail billDetail);

}
