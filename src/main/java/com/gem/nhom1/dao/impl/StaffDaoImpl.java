package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.StaffDao;
import com.gem.nhom1.model.Staff;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vanhop on 1/20/16.
 */
@Repository
@Transactional
public class StaffDaoImpl extends AbstractDao<Integer,Staff> implements StaffDao{
    public void save(Staff staff) {
        persist(staff);
    }

    public Staff getStaffById(int id) {
        return getByKey(id);
    }
}
