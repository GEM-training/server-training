package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.BillDao;
import com.gem.nhom1.model.entities.Bill;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phuongtd on 20/01/2016.
 */
@Repository
public class BillDaoImpl extends AbstractDao<Integer, Bill> implements BillDao {
    @Autowired
    private Constant constant;

    public Bill getById(int id) {
        return getByKey(id);
    }

    public List<Bill> getList(int startIndex) {

        Query query = getSession().createQuery("from  Bill b where  b.billId > :startIndex order by b.billId asc" );
        query.setParameter("startIndex" , startIndex);
        query.setMaxResults(constant.getMaxPageSize());
        return query.list();
    }

    public int insert(Bill bill){
        return insertObject(bill);
    }

    public void delete(int billId) throws Exception {
        deleteObject(getByKey(billId));
    }

    public void update(Bill bill){
        updateObject(bill);
    }
}
