package com.gem.nhom1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by phuong on 1/19/2016.
 */
@Entity
@Table(name = "dealers")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dealer_id")
    private int dealerId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL  , mappedBy = "dealer")
    private Set<Inventory> inventorys = new HashSet<Inventory>(0) ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "dealer" , fetch = FetchType.LAZY)
    private Set<UnitDealer> unitDealers = new HashSet<UnitDealer>(0);

    public Dealer() {
    }

    public Dealer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Dealer(String name, String address, Set<Inventory> inventorys) {
        this.name = name;
        this.address = address;
        this.inventorys = inventorys;
    }

    public Dealer(String name, String address, Set<Inventory> inventorys, Set<UnitDealer> unitDealers) {
        this.name = name;
        this.address = address;
        this.inventorys = inventorys;
        this.unitDealers = unitDealers;
    }

    public int getDealerId() {
        return dealerId;
    }


    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }


    public Set<Inventory> getInventorys() {
        return inventorys;
    }


    public Set<UnitDealer> getUnitDealers() {
        return unitDealers;
    }

    public void setUnitDealers(Set<UnitDealer> unitDealers) {
        this.unitDealers = unitDealers;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInventorys(Set<Inventory> inventorys) {
        this.inventorys = inventorys;
    }




}
