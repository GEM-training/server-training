package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.StaffDao;
import com.gem.nhom1.dao.impl.AbstractDao;
import com.gem.nhom1.model.ResponseDTO;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.service.StaffService;
import com.gem.nhom1.util.Constant;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    public ResponseDTO getById(int id) {
       // Staff staff = staffDao.getById(id);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , staffDao.getById(id));
    }

    public ResponseDTO getList(int page) {
       // return staffDao.getList(page);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , staffDao.getList(page));
    }

    public ResponseDTO insert(Staff staff){

        staffDao.insert(staff);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }

    public ResponseDTO delete(int id) throws Exception {
        staffDao.delete(id);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }

    public ResponseDTO update(Staff staff) {

        staffDao.update(staff);
        return new ResponseDTO(Constant.RESPONSE_STATUS_SUSSCESS , "" , null);
    }
}

