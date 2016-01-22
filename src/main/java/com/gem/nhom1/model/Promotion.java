package com.gem.nhom1.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by nghicv on 20/01/2016.
 */

@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private int id;

    @Min(value = 0, message = "Không được nhập số âm")
    @Digits(integer = 10,fraction = 2, message = "Số quá lớn")
    @Column(name = "saleoff")
    private double saleOff;

    @NotNull(message = "Trường không được để rỗng")
    @Column(name = "starttime")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate startTime;

    @NotNull(message = "Trường không được để rỗng")
    @Column(name = "endtime")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate endTime;

    @ManyToOne
    @JoinColumn(name = "unit_id" ,nullable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "dealer_id" ,nullable = false)
    private Dealer dealer;

    public Promotion(double saleOff, LocalDate startTime, LocalDate endTime, Unit unit, Dealer dealer) {
        this.saleOff = saleOff;
        this.startTime = startTime;
        this.endTime = endTime;
        this.unit = unit;
        this.dealer = dealer;
    }

    public Promotion(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSaleOff(double saleOff) {
        this.saleOff = saleOff;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getId() {
        return id;
    }

    public double getSaleOff() {
        return saleOff;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public Dealer getDealer() {
        return dealer;
    }
}