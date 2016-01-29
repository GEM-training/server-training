package com.gem.nhom1.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.Index;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vanhop on 1/18/16.
 */
@Entity
@Indexed
@Table(name = "UNITS")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_ID")
    private Integer unitId;

    @NotNull(message = "Type không được để rỗng")
    @Length(min = 1,max = 50,message = "Type có độ dài từ 1 đến 50")
    @Column(name = "TYPE")
    @Field
    private String type;

    @NotNull(message = "Is_part không được để rỗng")
    @Column(name = "IS_PART")
    @Field
    private Integer isPart;

    @ManyToOne
    @JoinColumn(name = "PART_OF" , nullable = true)
    private Unit partOf;

    @OneToMany(mappedBy = "partOf")
    @JsonIgnore
    private Set<Unit> units;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    @JsonIgnore
    private Set<UnitDealer> unitDealers = new HashSet<UnitDealer>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.unit", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<BillDetail> billDetail = new HashSet<BillDetail>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    @JsonIgnore
    private Set<Promotion> promotions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryUnitId.unit")
    @JsonIgnore
    private Set<InventoryUnit> inventoryUnits = new HashSet<InventoryUnit>();

    public Unit() {
    }

    public Unit(String type, Integer isPart) {
        this.type = type;
        this.isPart = isPart;
    }

    public Unit(String type, Integer isPart, Unit partOf) {
        this.type = type;
        this.isPart = isPart;
        this.partOf = partOf;
    }

    public Unit(String type, Integer isPart, Unit partOf, Set<Unit> units, Set<UnitDealer> unitDealers) {
        this.type = type;
        this.isPart = isPart;
        this.partOf = partOf;
        this.units = units;
        this.unitDealers = unitDealers;
    }

    public Set<BillDetail> getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(Set<BillDetail> billDetail) {
        this.billDetail = billDetail;
    }

    public Unit(String type, Integer isPart, Unit partOf, Set<Unit> units, Set<UnitDealer> unitDealers, Set<Promotion> promotions) {
        this.type = type;
        this.isPart = isPart;
        this.partOf = partOf;
        this.units = units;
        this.unitDealers = unitDealers;
        this.promotions = promotions;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public Set<UnitDealer> getUnitDealers() {
        return unitDealers;
    }

    public Set<Unit> getUnits() {
        return units;
    }

    public Unit getPartOf() {
        return partOf;
    }

    public String getType() {
        return type;
    }

    public Integer getIsPart() {
        return isPart;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public void setUnits(Set<Unit> units) {
        this.units = units;
    }

    public void setUnitDealers(Set<UnitDealer> unitDealers) {
        this.unitDealers = unitDealers;
    }

    public void setPartOf(Unit partOf) {
        this.partOf = partOf;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIsPart(Integer isPart) {
        this.isPart = isPart;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Set<InventoryUnit> getInventoryUnits() {
        return inventoryUnits;
    }

    public void setInventoryUnits(Set<InventoryUnit> inventoryUnits) {
        this.inventoryUnits = inventoryUnits;
    }
}