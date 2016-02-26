package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.Promotion;

import java.util.List;

/**
 * Created by nghicv on 20/01/2016.
 */
interface PromotionDao {

    int insert(Promotion promotion);
    List<Promotion> getList(int startIndex);
    Promotion getById(int id);
    void delete(int id) throws Exception;
    void update(Promotion promotion);
}

