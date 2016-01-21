package com.gem.nhom1.dao;

import com.gem.nhom1.model.Dealer;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
public interface DealerDao {
    public void save(Dealer dealer);
    public List<Dealer> getListDealer();
    public Dealer getDealerById(int id);

    public void deleteDealer(int dealerId);

    public int insertDealer(Dealer dealer);

}
