package com.gem.nhom1.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by nghicv on 21/01/2016.
 */

@Embeddable
public class InventoryUnitId implements Serializable{

    @ManyToOne
    private Inventory inventory;

    @ManyToOne
    private Unit unit;

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
