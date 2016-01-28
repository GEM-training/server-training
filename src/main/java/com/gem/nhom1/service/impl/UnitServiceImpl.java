package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.UnitDao;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.UnitService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
@Service
@Transactional
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitDao unitDao;

    public Unit getById(int id) {
        Unit unit = unitDao.getById(id);
        Hibernate.initialize(unit.getUnitDealers());
        if(unit.getIsPart() == 0)
            Hibernate.initialize(unit.getUnits());
        return unit;
    }

    public List<Unit> getList(int page) {
        List<Unit> unitList = unitDao.getList(page);
        for(Unit unit : unitList) {
            Hibernate.initialize(unit.getUnitDealers());
            Hibernate.initialize(unit.getUnits());
        }
        return unitList;
    }

    public int insert(Unit unit) {
        return unitDao.insert(unit);
    }

    public boolean delete(int id) {
        return unitDao.delete(id);
    }

    public void update(Unit unit) {
        unitDao.update(unit);
    }
}
