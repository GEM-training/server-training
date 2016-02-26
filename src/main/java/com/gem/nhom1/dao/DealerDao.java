package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Dealer;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
public interface DealerDao {
     Dealer getById(int id);
    List<Dealer> getList(int startIndex,int pageSize);
    int insert(Dealer dealer);
    void delete(int dealerId) throws Exception;
    void update(Dealer dealer);

    void insertOrUpdate();

}
