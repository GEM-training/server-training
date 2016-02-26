package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Unit;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
public interface UnitDao {

    Unit getById(int id);
    List<Unit> getList(int startIndex);
    int insert(Unit unit);
    void delete(int id) throws Exception;
    void update(Unit unit);

    Session getSession();
}
