package com.gem.nhom1.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @NotNull(message = "Trạng thái không được rỗng")
    @Length(min = 1, max = 1, message = "Trạng thái không hợp lệ")
    @Column(name = "state" , length = 50)
    private String state;


    @Column(name = "create_date")
    private Date ceateDate;

    @Column(name = "update_date" )
    private Date updateDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.bill", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonBackReference
    private Set<BillDetail> billDetail = new HashSet<BillDetail>();

    public Bill() {
    }

    public Bill(Customer customer, Dealer dealer, String state) {
        this.customer = customer;
        this.dealer = dealer;
        this.state = state;
    }

    public Set<BillDetail> getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(Set<BillDetail> billDetail) {
        this.billDetail = billDetail;
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


    public Date getCeateDate() {
        return ceateDate;
    }

    public void setCeateDate(Date ceateDate) {
        this.ceateDate = ceateDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Bill(Customer customer, Dealer dealer, String state, Date ceateDate, Date updateDate, Set<BillDetail> billDetail) {
        this.customer = customer;
        this.dealer = dealer;
        this.state = state;
        this.ceateDate = ceateDate;
        this.updateDate = updateDate;
        this.billDetail = billDetail;
    }
}
