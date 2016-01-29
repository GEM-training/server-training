package com.gem.nhom1.model.entities;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by nghicv on 21/01/2016.
 */

@Embeddable
public class InventoryUnitId implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Unit unit;

    public InventoryUnitId(Inventory inventory, Unit unit) {
        this.inventory = inventory;
        this.unit = unit;
    }

    public InventoryUnitId(){

    }

    public Inventory getInventory() {
        return inventory;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}