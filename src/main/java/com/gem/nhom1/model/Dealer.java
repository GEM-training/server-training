package com.gem.nhom1.model;

import javax.persistence.*;

/**
 * Created by vanhop on 1/19/16.
 */

@Entity
@Table(name = "dealers")

public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dealer_id")
    private Integer dealerId;

    @Column(name = "n")
    private String name;

    @Column(name = "address")
    private String address;

    public Dealer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
