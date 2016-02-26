package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.*;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
public interface DealerService {
    Dealer getById(int id);
    List<Dealer> getList(int startIndex,int pageSize);
    int insert(Dealer dealer);
    void delete(int dealerId) throws Exception;
    void update(Dealer dealer);
    public List<UnitDealer> getListUnitDealer(int dealerId , int startIndex , int pageSize);

    List<Inventory> getListInventory(int dealerId);
    List<Staff> getListStaff(int deaerId);

    List<Bill> getListBill(int dealerId);

    List<Promotion> getListPromotions(int dealerId);

}
