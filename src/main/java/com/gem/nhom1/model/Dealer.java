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

    private int dealerId;


    private String name;


    private String address;


    private Set<Inventory> inventorys = new HashSet<Inventory>(0) ;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dealer_id")
    public int getDealerId() {
        return dealerId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    @OneToMany(cascade = CascadeType.ALL  , mappedBy = "dealer")
    public Set<Inventory> getInventorys() {
        return inventorys;
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
