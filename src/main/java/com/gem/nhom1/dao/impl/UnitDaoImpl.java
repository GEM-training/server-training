package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.UnitDao;
import com.gem.nhom1.model.entities.Unit;
import org.apache.taglibs.standard.extra.spath.ParseException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */

@Repository
public class UnitDaoImpl extends AbstractDao<Integer, Unit> implements UnitDao {

    @Autowired
    private Constant constant;

    public Unit getById(int id) {
        return getByKey(id);
    }

    public List<Unit> getList(int startIndex) {
        Query query = getSession().createQuery("from  Unit u where  u.unitId > :startIndex order by u.unitId asc" );
        query.setParameter("startIndex" , startIndex);
        query.setMaxResults(constant.getMaxPageSize());
        return query.list();

    }

    public int insert(Unit unit){
        return insertObject(unit);
    }

    public void delete(int id) throws Exception {
        deleteObject(getByKey(id));
    }

    public void update(Unit unit){
        updateObject(unit);
    }

    public Session getSession_(){
        return  getSession();
    }

   /* @Transactional
    public List<Unit> search(String key) {
        Session session = getSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Unit.class).get();
        org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("type").matching(key).createQuery();

        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Unit.class);

        List<Unit> contactList = fullTextQuery.list();

        //fullTextSession.close();

        return contactList;
    }*/
}

