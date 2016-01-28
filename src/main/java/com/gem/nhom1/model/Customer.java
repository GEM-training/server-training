package com.gem.nhom1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vanhop on 1/18/16.
 */
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Integer id;

    @NotNull(message = "Trường không được để rỗng")
    @NotBlank(message = "Trường không được để rỗng")
    @NotEmpty(message = "Trường không được để rỗng")
    @Length(min = 3, max = 100, message = "Độ dài tên từ 3 đến 100 kí tự")
    @Column(name = "NAME")
    private String name;

    @NotNull(message = "Trường không được để rỗng")
    @NotBlank(message = "Trường không được để rỗng")
    @NotEmpty(message = "Trường không được để rỗng")
    @Length(min = 3, max = 50, message = "Độ dài từ phone từ 3 đến 50")
    @Column(name = "PHONE")
    private String phone;

    @NotNull(message = "Trường không được để rỗng")
    @NotBlank(message = "Trường không được để rỗng")
    @NotEmpty(message = "Trường không được để rỗng")
    @Length(min = 1, max = 50, message = "Địa chỉ có độ dài từ 1 đến 50 kí tự")
    @Column(name = "ADDRESS" ,length = 50 , nullable = false)
    private String address;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
    @JsonIgnore
    private Set<Bill> bills = new HashSet<Bill>();

    public Customer() {
    }

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String name, String phone, String address, Set<Bill> bills) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.bills = bills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }
}