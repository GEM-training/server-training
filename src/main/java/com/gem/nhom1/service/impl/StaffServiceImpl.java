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

    public Staff getById(int id) {
        Staff staff = staffDao.getById(id);
        return  staff;
    }

    public List<Staff> getList(int page) {
        return staffDao.getList(page);
    }

    public int insert(Staff staff){
       return staffDao.insert(staff);
    }

    public void delete(int id) throws Exception {
        staffDao.delete(id);
    }

    public void update(Staff staff) {
        staffDao.update(staff);
    }
}

