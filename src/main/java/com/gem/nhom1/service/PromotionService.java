package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.Promotion;

import java.util.List;

/**
 * Created by nghicv on 20/01/2016.
 */
public interface PromotionService {

    public int insert(Promotion promotion);
    public List<Promotion> getList(int startIndex);
    public Promotion getById(int id);
    public void delete(int id) throws Exception;
    public void update(Promotion promotion);
}
