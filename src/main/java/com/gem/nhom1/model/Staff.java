package com.gem.nhom1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vanhop on 1/18/16.
 */
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "staff")
    private Set<Bill> bills = new HashSet<Bill>(0);

    public Staff() {
    }

    public Staff(String name, String phone, String address, Dealer dealer) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dealer = dealer;
    }

    public Staff(String name, String phone, String address, Dealer dealer, Set<Bill> bills) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dealer = dealer;
        this.bills = bills;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {

        this.bills = bills;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}