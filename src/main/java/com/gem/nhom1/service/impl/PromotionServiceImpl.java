package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.PromotionDao;
import com.gem.nhom1.model.Promotion;
import com.gem.nhom1.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nghicv on 20/01/2016.
 */

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService{

    @Autowired
    PromotionDao dao;

    public void save(Promotion promotion) {
        dao.save(promotion);
    }

    public List<Promotion> getListPromotion() {
        return dao.getListPromotion();
    }

    public Promotion getPromotionById(int id) {
        return dao.getPromotionById(id);
    }
}
