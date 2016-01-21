package com.gem.nhom1.service;

import com.gem.nhom1.model.Dealer;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
public interface DealerService {
    public  Dealer getById(int id);
    public List<Dealer> getList();
    public int insert(Dealer dealer);
    public boolean delete(int dealerId);
    public void update(Dealer dealer);
}
