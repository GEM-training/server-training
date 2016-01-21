package com.gem.nhom1.dao.impl;

import com.gem.nhom1.dao.PromotionDao;
import com.gem.nhom1.model.Promotion;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nghicv on 20/01/2016.
 */

@Repository
public class PromotionDaoImpl extends AbstractDao<Integer, Promotion> implements PromotionDao{

    public int insert(Promotion promotion) {
        return insertObject(promotion);
    }

    public List<Promotion> getList() {
        return getSession().createQuery("from Promotion").list();
    }

    public Promotion getById(int id) {
        return getByKey(id);
    }

    public boolean delete(int id) {

        try {
            deleteObject(getById(id));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void update(Promotion promotion) {
        updateObject(promotion);
    }
}
