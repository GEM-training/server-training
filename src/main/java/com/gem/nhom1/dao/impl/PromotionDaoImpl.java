package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.PromotionDao;
import com.gem.nhom1.model.entities.Promotion;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nghicv on 20/01/2016.
 */

@Repository
public class PromotionDaoImpl extends AbstractDao<Integer, Promotion> implements PromotionDao {

    @Autowired
    private Constant constant;

    public int insert(Promotion promotion){
        return insertObject(promotion);
    }

    public List<Promotion> getList(int startIndex) {
        Query query = getSession().createQuery("from  Promotion p where  p.id > :startIndex order by p.id asc" );
        query.setParameter("startIndex" , startIndex);
        query.setMaxResults(constant.getMaxPageSize());
        return query.list();
    }

    public Promotion getById(int id) {
        return getByKey(id);
    }

    public void delete(int id) {
        deleteObject(getById(id));
    }

    public void update(Promotion promotion){
        updateObject(promotion);
    }
}
