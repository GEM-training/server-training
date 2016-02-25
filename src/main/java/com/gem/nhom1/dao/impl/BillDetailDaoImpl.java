package com.gem.nhom1.dao.impl;

import com.gem.nhom1.config.Constant;
import com.gem.nhom1.config.HibernateConfiguration;
import com.gem.nhom1.dao.BillDetailDao;
import com.gem.nhom1.model.entities.BillDetail;
import com.gem.nhom1.model.entities.BillDetailId;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vanhop on 1/20/16.
 */
@Repository
@Transactional
public class BillDetailDaoImpl extends AbstractDao<BillDetailId, BillDetail> implements BillDetailDao {

    @Autowired
    private Constant constant;

    public BillDetail getById(BillDetailId id) {
        return getByKey(id);
    }

    public List<BillDetail> getList(int page)
    {
        Query query =  getSession().createQuery("from BillDetail");
        query.setFirstResult((page - 1) * constant.getMaxPageSize());
        query.setMaxResults(constant.getMaxPageSize());

        return query.list();
    }

    public BillDetailId insert(BillDetail billDetail){
        return insertObject(billDetail);
    }

    public void delete(BillDetailId id) throws Exception {
        deleteObject(getByKey(id));
    }

    public void update(BillDetail billDetail){
        updateObject(billDetail);
    }
}
