package com.gem.nhom1.util;

import com.gem.nhom1.model.entities.Dealer;

/**
 * Created by Alex on 8/4/2016.
 */
public class DealerBuilder {

    public static Dealer createDealer(int id, String name, String address){
        Dealer dealer = new Dealer(name, address);
        dealer.setDealerId(id);
        return dealer;
    }

}
