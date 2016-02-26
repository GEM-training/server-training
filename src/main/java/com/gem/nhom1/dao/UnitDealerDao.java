package com.gem.nhom1.dao;

import com.gem.nhom1.model.entities.UnitDealer;
import com.gem.nhom1.model.entities.UnitDealerId;

import java.util.List;

/**
 * Created by phuongtd on 21/01/2016.
 */
public interface UnitDealerDao {
    UnitDealer getById(UnitDealerId id);
    List<UnitDealer> getList(int page);
    UnitDealerId insert(UnitDealer unitDealer);
    void delete(UnitDealerId id) throws Exception;
    void update(UnitDealer unitDealer);

    public List<UnitDealer> getListUnitOfDealerByDealerId (int dealerId , int startIndex , int pageSize);

}
