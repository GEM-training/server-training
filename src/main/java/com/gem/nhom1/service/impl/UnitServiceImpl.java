package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.UnitDao;
import com.gem.nhom1.model.Unit;
import com.gem.nhom1.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vanhop on 1/18/16.
 */
@Service
@Transactional
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitDao unitDao;
    public void save(Unit unit) {
        unitDao.save(unit);
    }

    public Unit getUnitById(int id) {
        return unitDao.getUnitById(id);
    }


}
