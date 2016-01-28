package com.gem.nhom1.service;

import com.gem.nhom1.model.ResponseDTO;
import com.gem.nhom1.model.Staff;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
public interface StaffService {

    public ResponseDTO getById(int id);
    public ResponseDTO getList(int page);
    public ResponseDTO insert(Staff staff);
    public ResponseDTO delete(int id) throws Exception;
    public ResponseDTO update(Staff staff);


}
