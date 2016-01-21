package com.gem.nhom1.dao;

import com.gem.nhom1.model.Staff;

/**
 * Created by vanhop on 1/20/16.
 */
public interface StaffDao {

    public void save(Staff staff);
    public Staff getStaffById(int id);

}
