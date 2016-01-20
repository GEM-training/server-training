package com.gem.nhom1.dao;

import com.gem.nhom1.model.Promotion;

import java.util.List;

/**
 * Created by nghicv on 20/01/2016.
 */
public interface PromotionDao {

    public void save(Promotion promotion);
    public List<Promotion> getListPromotion();
    public Promotion getPromotionById(int id);
}

