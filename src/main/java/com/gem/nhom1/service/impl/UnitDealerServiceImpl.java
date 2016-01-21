package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.UnitDealerDao;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.model.UnitDealer;
import com.gem.nhom1.model.UnitDealerId;
import com.gem.nhom1.service.UnitDealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vanhop on 1/21/16.
 */
@Service
@Transactional
public class UnitDealerServiceImpl implements UnitDealerService{
    @Autowired
    private UnitDealerDao unitDealerDao;
    public UnitDealer getById(UnitDealerId id) {
        return unitDealerDao.getById(id);
    }

    public List<UnitDealer> getList() {
        return null;
    }

    public int insert(UnitDealer unitDealer) {
        return 0;
    }

    public boolean delete(UnitDealerId id) {
        return false;
    }

    public void update(UnitDealer unitDealer) {

    }
}
