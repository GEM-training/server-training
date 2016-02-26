package com.gem.nhom1.service;

import com.gem.nhom1.model.entities.UnitDealer;
import com.gem.nhom1.model.entities.UnitDealerId;

import java.util.List;

/**
 * Created by vanhop on 1/21/16.
 */
public interface UnitDealerService {

    UnitDealer getById(UnitDealerId id);
    List<UnitDealer> getList(int page);
    UnitDealerId insert(UnitDealer unitDealer);
    void delete(UnitDealerId id) throws Exception;
    void update(UnitDealer unitDealer);

}
