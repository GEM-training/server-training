package com.gem.nhom1.dao;

import com.gem.nhom1.model.UnitDealer;
import com.gem.nhom1.model.UnitDealerId;

import java.util.List;

/**
 * Created by phuongtd on 21/01/2016.
 */
public interface UnitDealerDao {
    public void save(UnitDealer unitDealer);
    public List<UnitDealer> getListUnitDealer();

    public UnitDealer getUnitDealerById(UnitDealerId unitDealerId);

}
