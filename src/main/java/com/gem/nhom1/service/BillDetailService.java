package com.gem.nhom1.service;

import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.model.entities.BillDetailId;

/**
 * Created by vanhop on 1/20/16.
 */
public interface BillDetailService {
    BillDetail getById(BillDetailId id);
    BillDetailId insert(BillDetail billDetail);
    void delete(BillDetailId id) throws Exception;
    void update(BillDetail billDetail);

}
