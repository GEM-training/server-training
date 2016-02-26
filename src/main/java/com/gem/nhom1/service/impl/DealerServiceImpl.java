package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.DealerDao;
import com.gem.nhom1.dao.UnitDao;
import com.gem.nhom1.dao.UnitDealerDao;
import com.gem.nhom1.model.entities.*;
import com.gem.nhom1.service.DealerService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by phuong on 1/19/2016.
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService {
    @Autowired
    private DealerDao dealerDao;

    @Autowired
    private UnitDao unitDao;

    @Autowired
    private UnitDealerDao unitDealerDao;


    public Dealer getById(int id) {
        return dealerDao.getById(id);
    }

    public List<Dealer> getList(int startIndex,int pageSize) {
        return dealerDao.getList(startIndex,pageSize);
    }

    public int insert(Dealer dealer){
        return dealerDao.insert(dealer);
    }

    public void delete(int dealerId) throws Exception {
        dealerDao.delete(dealerId);
    }

    public void update(Dealer dealer){
        dealerDao.update(dealer);
    }

    public List<UnitDealer> getListUnitDealer(int dealerId , int startIndex , int pageSize) {
        return unitDealerDao.getListUnitOfDealerByDealerId(dealerId , startIndex ,pageSize);
    }

    public List<Inventory> getListInventory(int dealerId) {
        Dealer d = getById(dealerId);
        Hibernate.initialize(d.getInventorys());
        return new ArrayList<Inventory>(d.getInventorys());
    }

    public List<Staff> getListStaff(int dealerId) {
        Dealer d = getById(dealerId);
        Hibernate.initialize(d.getStaffs());
        return new ArrayList<Staff>(d.getStaffs());
    }

    public List<Bill> getListBill(int dealerId) {
        Dealer d = getById(dealerId);
        Hibernate.initialize(d.getBills());

        List<Bill> result = new ArrayList<Bill>(d.getBills());

        for(Bill bill : result){
            Hibernate.initialize(bill.getCustomer());
            Hibernate.initialize(bill.getBillDetail());
            List<BillDetail> billDetails = new ArrayList<BillDetail>(bill.getBillDetail());
            for(BillDetail billDetail : billDetails)
                Hibernate.initialize(billDetail.getUnit());
        }

        return result;
    }

    public double getPrice(int dealerId, int unitId) {
        UnitDealerId unitDealerId = new UnitDealerId(unitId , dealerId);
        UnitDealer unitDealer = unitDealerDao.getById(unitDealerId);
        return unitDealer.getPrice();
    }

    public List<Promotion> getListPromotions(int dealerId) {
        Dealer dealer = getById(dealerId);
        Hibernate.initialize(dealer.getPromotions());
        return new ArrayList<Promotion>(dealer.getPromotions());
    }
}
