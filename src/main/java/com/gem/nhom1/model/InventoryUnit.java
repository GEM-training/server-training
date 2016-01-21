package com.gem.nhom1.model;

import javax.persistence.*;

/**
 * Created by nghicv on 21/01/2016.
 */

@Entity
@Table(name = "inventory_unit")
@AssociationOverrides({
        @AssociationOverride(name = "pk.inventory", joinColumns = @JoinColumn(name = "inventory_id")),
        @AssociationOverride(name = "pk.unit", joinColumns = @JoinColumn(name ="unit_id"))
})
public class InventoryUnit {

    @EmbeddedId
    private InventoryUnitId pk;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Transient
    public Unit getUnit(){
        return pk.getUnit();
    }

    public void setunit(Unit unit){
        pk.setUnit(unit);
    }

    @Transient
    public Inventory getInventory(){
        return pk.getInventory();
    }

    public void setInventory(Inventory inventory){
        pk.setInventory(inventory);
    }

    public InventoryUnitId getPk() {
        return pk;
    }

    public void setPk(InventoryUnitId pk) {
        this.pk = pk;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
