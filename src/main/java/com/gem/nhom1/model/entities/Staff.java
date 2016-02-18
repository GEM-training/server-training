package com.gem.nhom1.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @NotNull(message = "Tên không được để rỗng")
    @Length(min = 3,max = 50, message = "Tên có độ dài từ 3 đến 50")
    @Column(name = "name")
    private String name;

    @Length(max = 50, message = "Số điện thoại có độ dài tối đa là 50")
    @Column(name = "phone" ,length = 50)
    private String phone;

    @Length(max = 100, message = "Địa chỉ có độ dài tối đa là 100")
    @Column(name = "address" , length = 100)
    private String address;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @OneToOne(mappedBy = "staff")
    @JsonIgnore
    private User user;


    public Staff() {
    }

    public Staff(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public Staff(String name, String phone, String address, Dealer dealer) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dealer = dealer;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}