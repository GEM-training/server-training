package com.gem.nhom1.dao;

import com.gem.nhom1.model.Staff;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
public interface StaffDao {

    public Staff getById(int id);
    public List<Staff> getList();
    public int insert(Staff staff);
    public void delete(int id) throws Exception;
    public void update(Staff staff);

}
