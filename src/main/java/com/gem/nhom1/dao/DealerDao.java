package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Dealer;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
public interface DealerDao {
    public  Dealer getById(int id);
    public List<Dealer> getList(int startIndex,int pageSize);
    public int insert(Dealer dealer);
    public void delete(int dealerId) throws Exception;
    public void update(Dealer dealer);

    public void insertOrUpdate();

}
