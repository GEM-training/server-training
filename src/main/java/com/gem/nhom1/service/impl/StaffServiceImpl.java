package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.StaffDao;
import com.gem.nhom1.model.entities.Staff;
import com.gem.nhom1.service.StaffService;
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
        return staffDao.getById(id);
    }

    public List<Staff> getList(int startIndex) {
        return staffDao.getList(startIndex);
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

