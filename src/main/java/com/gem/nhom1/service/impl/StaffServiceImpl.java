package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.StaffDao;
import com.gem.nhom1.dao.impl.AbstractDao;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    public Staff getById(int id) {
        return staffDao.getById(id);
    }

    public List<Staff> getList() {
        return staffDao.getList();
    }

    public int insert(Staff staff) {
        return staffDao.insert(staff);
    }

    public boolean delete(int id) {
        return staffDao.delete(id);
    }

    public void update(Staff staff) {
        staffDao.update(staff);
    }
}

