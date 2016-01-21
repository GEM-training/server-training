package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.StaffDao;
import com.gem.nhom1.model.Staff;

import java.util.List;

/**
 * Created by vanhop on 1/21/16.
 */
public class StaffDaoImpl extends AbstractDao<Integer,Staff> implements StaffDao {
    public Staff getById(int id) {
        return getByKey(id);
    }

    public List<Staff> getList() {
        return null;
    }

    public boolean delete(int id) {
        try {
            delete(getByKey(id));
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
