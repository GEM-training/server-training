package com.gem.nhom1.service;

import com.gem.nhom1.model.BillDetail;
import com.gem.nhom1.model.BillDetailId;
import com.gem.nhom1.model.ResponseDTO;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
public interface BillDetailService {
    public ResponseDTO getById(BillDetailId id);
    public ResponseDTO insert(BillDetail billDetail);
    public ResponseDTO delete(BillDetailId id) ;
    public ResponseDTO update(BillDetail billDetail);

}
