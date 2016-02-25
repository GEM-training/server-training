package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.*;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
public interface DealerService {
    public  Dealer getById(int id);
    public List<Dealer> getList(int startIndex,int pageSize);
    public int insert(Dealer dealer);
    public void delete(int dealerId) throws Exception;
    public void update(Dealer dealer);

    public List<UnitDealer> getListUnitDealer(int dealerId);
    public List<Inventory> getListInventory(int dealerId);
    public List<Staff> getListStaff(int deaerId);

    public List<Bill> getListBill(int dealerId);

    public double getPrice(int dealerId , int unitId);

    public List<Promotion> getListPromotions(int dealerId);


    public void demo();

}
