package com.gem.nhom1.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;

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

    @Column(name = "saleoff")
    private double saleOff;

    @Column(name = "starttime", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate startTime;

    @Column(name = "endtime", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate endTime;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "dealer_id")
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