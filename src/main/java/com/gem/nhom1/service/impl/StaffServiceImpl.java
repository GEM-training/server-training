package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.StaffDao;
import com.gem.nhom1.dao.impl.AbstractDao;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vanhop on 1/20/16.
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    public void save(Staff staff) {
        staffDao.save(staff);
    }

    public Staff getStaffById(int id) {
        return staffDao.getStaffById(id);
    }
}
