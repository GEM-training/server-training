package com.gem.nhom1.service;

import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.model.entities.BillDetailId;

/**
 * Created by vanhop on 1/20/16.
 */
public interface BillDetailService {
    public BillDetail getById(BillDetailId id);
    public BillDetailId insert(BillDetail billDetail);
    public void delete(BillDetailId id) throws Exception;
    public void update(BillDetail billDetail);

}
