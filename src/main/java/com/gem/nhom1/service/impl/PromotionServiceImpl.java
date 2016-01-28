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
    private PromotionDao dao;

    public int insert(Promotion promotion) {
        return dao.insert(promotion);
    }

    public List<Promotion> getList(int page) {
        return dao.getList(page);
    }

    public Promotion getById(int id) {
        return dao.getById(id);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }

    public void update(Promotion promotion) {
        dao.update(promotion);
    }
}
