package com.gem.nhom1.dao;

import com.gem.nhom1.model.Promotion;

import java.util.List;

/**
 * Created by nghicv on 20/01/2016.
 */
public interface PromotionDao {

    public int insert(Promotion promotion);
    public List<Promotion> getList();
    public Promotion getById(int id);
    public boolean delete(int id);
    public void update(Promotion promotion);
}

