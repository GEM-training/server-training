package com.gem.nhom1.model;

import javax.persistence.*;

/**
 * Created by nghicv on 21/01/2016.
 */


@Entity
@Table(name = "inventory_unit")
@AssociationOverrides({
        @AssociationOverride(name = "inventoryUnitId.inventory", joinColumns = @JoinColumn(name = "inventory_id")),
        @AssociationOverride(name = "inventoryUnitId.unit", joinColumns = @JoinColumn(name ="unit_id"))
})
public class InventoryUnit {

    @EmbeddedId
    private InventoryUnitId inventoryUnitId;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Transient
    public Unit getUnit(){
        return inventoryUnitId.getUnit();
    }

    public void setUnit(Unit unit){
        inventoryUnitId.setUnit(unit);
    }

    @Transient
    public Inventory getInventory(){
        return inventoryUnitId.getInventory();
    }

    public void setInventory(Inventory inventory){
        inventoryUnitId.setInventory(inventory);
    }

    public InventoryUnitId getInventoryUnitId() {
        return inventoryUnitId;
    }

    public void setInventoryUnitId(InventoryUnitId inventoryUnitId) {
        this.inventoryUnitId = inventoryUnitId;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
