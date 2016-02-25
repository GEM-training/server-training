package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.StaffDao;
import com.gem.nhom1.model.entities.Staff;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vanhop on 1/21/16.
 */
@Repository
public class StaffDaoImpl extends AbstractDao<Integer, Staff> implements StaffDao {

    @Autowired
    private Constant constant;

    public Staff getById(int id) {
        return getByKey(id);
    }

    public List<Staff> getList(int startIndex) {
        Query query = getSession().createQuery("from  Staff s where  s.staffId > :startIndex order by s.staffId asc" );
        query.setParameter("startIndex" , startIndex);
        query.setMaxResults(constant.getMaxPageSize());
        return query.list();
    }

    public int insert(Staff staff){
        return insertObject(staff);
    }

    public void delete(int id) throws Exception {
        deleteObject(getByKey(id));
    }

    public void update(Staff staff){
        updateObject(staff);
    }
}

