package com.gem.nhom1.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vanhop on 1/18/16.
 */
@Entity
@Table(name = "UNITS")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_ID")
    private Integer unitId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "IS_PART")
    private Integer isPart;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="PART_OF")
    private Unit partOf;

    @OneToMany(mappedBy = "partOf")
    private Set<Unit> units;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "unit")
    private Set<UnitDealer> unitDealers = new HashSet<UnitDealer>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.unit", cascade = CascadeType.ALL)
    private Set<BillDetail> billDetail = new HashSet<BillDetail>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit")
    private Set<Promotion> promotions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryUnitId.unit", cascade = CascadeType.ALL)
    private Set<InventoryUnit> inventoryUnits = new HashSet<InventoryUnit>();

    public Unit() {
    }

    public Unit(String type, Integer isPart) {
        this.type = type;
        this.isPart = isPart;
    }

    public Unit(Integer isPart, Unit partOf, Set<Unit> units, Set<UnitDealer> unitDealers) {
        this.isPart = isPart;
        this.partOf = partOf;
        this.units = units;
        this.unitDealers = unitDealers;
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