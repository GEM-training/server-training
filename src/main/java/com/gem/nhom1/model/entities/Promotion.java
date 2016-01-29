package com.gem.nhom1.model.entities;

import java.util.Date;

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

    @Min(value = 0, message = "Giảm gía không được nhập số âm")
    @Digits(integer = 10,fraction = 2, message = "Số giảm quá quá lớn")
    @Column(name = "saleoff")
    private double saleOff;

    @NotNull(message = "Thời gian không được để rỗng")
    @Column(name = "starttime")
    private Date startTime;

    @NotNull(message = "Thời gian không được để rỗng")
    @Column(name = "endtime")
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "unit_id" ,nullable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "dealer_id" ,nullable = false)
    private Dealer dealer;

    public Promotion(double saleOff, Date startTime, Date endTime, Unit unit, Dealer dealer) {
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

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
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

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Dealer getDealer() {
        return dealer;
    }
}