package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.Unit;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
public interface UnitService {
    public Unit getById(int id);
    public List<Unit> getList(int startIndex);
    public int insert(Unit unit);
    public void delete(int id) throws Exception;
    public void update(Unit unit);

    public List<Unit> search(String key);
}
