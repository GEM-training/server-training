package com.gem.nhom1.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by vanhop on 1/19/16.
 */


@Entity
@Table(name = "inventorys")
public class Inventory {

    private Integer inventoryId;

    private String name;


    private String address;


    @ManyToOne
    private Dealer dealer;


}
