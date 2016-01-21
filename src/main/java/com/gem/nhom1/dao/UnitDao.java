package com.gem.nhom1.dao;

import com.gem.nhom1.model.Unit;

/**
 * Created by vanhop on 1/18/16.
 */
public interface UnitDao {

    public void save(Unit unit);
    public Unit getUnitById(int id);
}
