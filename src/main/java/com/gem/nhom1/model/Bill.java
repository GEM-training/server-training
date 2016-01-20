package com.gem.nhom1.model;

import javax.persistence.*;

/**
 * Created by phuongtd on 20/01/2016.
 */
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int billId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @Column(name = "state")
    private String state;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private Staff staff;

    public Bill() {
    }

    public Bill(Customer customer, Dealer dealer, String state, Staff staff) {
        this.customer = customer;
        this.dealer = dealer;
        this.state = state;
        this.staff = staff;
    }


    public int getBillId() {
        return billId;
    }


    public Customer getCustomer() {
        return customer;
    }


    public Dealer getDealer() {
        return dealer;
    }


    public String getState() {
        return state;
    }


    public Staff getStaff() {
        return staff;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
