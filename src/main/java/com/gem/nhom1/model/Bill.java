package com.gem.nhom1.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Trường này không được rỗng")
    @NotEmpty(message = "Trường này không được rỗng")
    @NotBlank(message = "Trường này không được rỗng")
    @Length(min = 1, max = 1, message = "Trạng thái không hợp lệ")
    @Column(name = "state" , length = 50)
    private String state;


    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.bill", cascade = CascadeType.ALL)
    private Set<BillDetail> billDetail = new HashSet<BillDetail>();

    public Bill() {
    }

    public Bill(Customer customer, Dealer dealer, String state, Staff staff) {
        this.customer = customer;
        this.dealer = dealer;
        this.state = state;
        this.staff = staff;
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
