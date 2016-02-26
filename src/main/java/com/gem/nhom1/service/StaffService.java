package com.gem.nhom1.service;


import com.gem.nhom1.model.entities.Staff;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
public interface StaffService {

    Staff getById(int id);
    List<Staff> getList(int startIndex);
    int insert(Staff staff);
    void delete(int id) throws Exception;
    void update(Staff staff);


}
