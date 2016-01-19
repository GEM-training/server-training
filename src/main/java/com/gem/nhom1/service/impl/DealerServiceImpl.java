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
    public void save(Dealer dealer) {
        dealerDao.save(dealer);
    }

    public List<Dealer> getListDealer() {
        return dealerDao.getListDealer();
    }

    public Dealer getDealerById(int id){
       return dealerDao.getDealerById(id);
    }


}
