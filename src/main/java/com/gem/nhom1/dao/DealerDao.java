package com.gem.nhom1.dao;

import com.gem.nhom1.model.Dealer;
import com.gem.nhom1.model.Inventory;
import com.gem.nhom1.model.Staff;
import com.gem.nhom1.model.Unit;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
public interface DealerDao {
    public  Dealer getById(int id);
    public List<Dealer> getList();
    public int insert(Dealer dealer);
    public boolean delete(int dealerId);
    public void update(Dealer dealer);

}
