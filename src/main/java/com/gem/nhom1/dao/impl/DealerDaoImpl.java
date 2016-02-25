package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.DealerDao;
import com.gem.nhom1.model.entities.Dealer;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phuong on 1/19/2016.
 */
@Repository
public class DealerDaoImpl extends AbstractDao<Integer, Dealer> implements DealerDao {

    @Autowired
    private Constant constant;

    public Dealer getById(int id) {
        return getByKey(id);
    }

    public List<Dealer> getList(int startIndex,int pageSize) {
        Query query = getSession().createQuery("from  Dealer d where  d.dealerId > :startIndex order by d.dealerId asc" );
        query.setParameter("startIndex" , startIndex);
        pageSize = pageSize < constant.getMaxPageSize() ? pageSize : constant.getMaxPageSize() ;
        query.setMaxResults(pageSize);
        return query.list();
    }

    public int insert(Dealer dealer){
        return insertObject(dealer);
    }

    public void delete(int dealerId) throws Exception {
        deleteObject(getByKey(dealerId));
    }

    public void update(Dealer dealer){
        updateObject(dealer);
    }

    public void insertOrUpdate(){
       /* Dealer d = getById(6);

        getSession().evict(d);*/

        Dealer d = new Dealer("@@@@" , "ADDRESS");

        d.setAddress("So 6 pho 666");

        getSession().saveOrUpdate(d);

    }

}
