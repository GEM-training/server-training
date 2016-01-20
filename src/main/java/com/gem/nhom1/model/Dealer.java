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

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "dealer")
    private Set<Bill> bills = new HashSet<Bill>(0);

    @OneToMany(cascade = CascadeType.ALL  , mappedBy = "dealer")
    private Set<Inventory> inventorys = new HashSet<Inventory>(0) ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "dealer")
    private Set<Staff> staffs = new HashSet<Staff>(0);

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

    public Dealer(String name, String address, Set<Bill> bills, Set<Inventory> inventorys) {
        this.name = name;
        this.address = address;
        this.bills = bills;
        this.inventorys = inventorys;
    }

    public Dealer(int dealerId, String name, String address, Set<Bill> bills, Set<Inventory> inventorys, Set<Staff> staffs) {
        this.dealerId = dealerId;
        this.name = name;
        this.address = address;
        this.bills = bills;
        this.inventorys = inventorys;
        this.staffs = staffs;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
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


    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
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