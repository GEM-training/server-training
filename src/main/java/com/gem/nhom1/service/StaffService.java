package com.gem.nhom1.service;


import com.gem.nhom1.model.entities.Staff;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
public interface StaffService {

    public Staff getById(int id);
    public List<Staff> getList(int page);
    public int insert(Staff staff);
    public void delete(int id) throws Exception;
    public void update(Staff staff);


}
