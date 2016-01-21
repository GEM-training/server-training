package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.DealerDao;
import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService {
    @Autowired
    private DealerDao dealerDao;

    public Dealer getById(int id) {
        return dealerDao.getById(id);
    }

    public List<Dealer> getList() {
        return dealerDao.getList();
    }

    public int insert(Dealer dealer) {
        return dealerDao.insert(dealer);
    }

    public boolean delete(int dealerId) {
        return dealerDao.delete(dealerId);
    }

    public void update(Dealer dealer) {
        dealerDao.update(dealer);
    }
}
