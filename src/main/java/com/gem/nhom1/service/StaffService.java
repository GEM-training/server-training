package com.gem.nhom1.service;

import com.gem.nhom1.model.Staff;

/**
 * Created by vanhop on 1/20/16.
 */
public interface StaffService {

    public void save(Staff staff);
    public Staff getStaffById(int id);

}
