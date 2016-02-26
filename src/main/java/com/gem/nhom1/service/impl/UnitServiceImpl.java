package com.gem.nhom1.service.impl;

import com.gem.nhom1.dao.UnitDao;
import com.gem.nhom1.model.entities.Unit;
import com.gem.nhom1.service.UnitService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vanhop on 1/18/16.
 */
@Service
@Transactional
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitDao unitDao;

    public Unit getById(int id) {
        Unit unit = unitDao.getById(id);
        Hibernate.initialize(unit.getUnitDealers());
        if(unit.getIsPart() == 0)
            Hibernate.initialize(unit.getUnits());
        return unit;
    }

    public List<Unit> getList(int startIndex) {
        List<Unit> unitList = unitDao.getList(startIndex);
        for(Unit unit : unitList) {
            Hibernate.initialize(unit.getUnitDealers());
            Hibernate.initialize(unit.getUnits());
        }
        return unitList;
    }

    public int insert(Unit unit){
        return unitDao.insert(unit);
    }

    public void delete(int id) throws Exception {
        unitDao.delete(id);
    }

    public void update(Unit unit) {
        unitDao.update(unit);
    }



    public List<Unit> search(String key) {
        Session session = unitDao.getSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Unit.class).get();
        org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("type").matching(key).createQuery();
        org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, Unit.class);
        return fullTextQuery.list();
    }
}
