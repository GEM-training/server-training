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
    private UnitDealerDao unitDealerDao;

    @Autowired
    private UnitDao unitDao;


    public Dealer getById(int id) {

        Dealer dealer = dealerDao.getById(id);
        return dealer;
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




    public List<UnitDealer> getListUnitDealer(int dealerId) {
        Dealer d = dealerDao.getById(dealerId);
        Hibernate.initialize(d.getUnitDealers());

        Set<UnitDealer> unitDealers = d.getUnitDealers();

        List<UnitDealer> result = new ArrayList<UnitDealer>(unitDealers);

        for(int i = 0 ; i< result.size() ; i++){
            Hibernate.initialize(result.get(i).getUnit());
        }

        return result;
    }

    public List<Inventory> getListInventory(int dealerId) {
        Dealer d = getById(dealerId);
        Hibernate.initialize(d.getInventorys());

        List<Inventory> result = new ArrayList<Inventory>(d.getInventorys());

        return result;
    }

    public List<Staff> getListStaff(int dealerId) {
        Dealer d = getById(dealerId);
        Hibernate.initialize(d.getStaffs());

        List<Staff> result = new ArrayList<Staff>(d.getStaffs());

        return result;
    }

    public List<Bill> getListBill(int dealerId) {
        Dealer d = getById(dealerId);
        Hibernate.initialize(d.getBills());

        List<Bill> result = new ArrayList<Bill>(d.getBills());

        for(int i = 0 ; i< result.size() ; i++){
            Hibernate.initialize(result.get(i).getCustomer());
            Hibernate.initialize(result.get(i).getBillDetail());

            List<BillDetail> billDetails = new ArrayList<BillDetail>(result.get(i).getBillDetail());
            for(int j = 0 ; j< billDetails.size() ; j++){
                BillDetail billDetail = billDetails.get(j);
                Hibernate.initialize(billDetail.getUnit());
            }
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

    public void demo(){
        dealerDao.insertOrUpdate();
    }
}
