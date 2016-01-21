package com.gem.nhom1.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

/**
 * Created by vanhop on 1/20/16.
 */

@Entity
@Table(name = "bill_details")
@AssociationOverrides({
        @AssociationOverride(name = "pk.bill", joinColumns = @JoinColumn(name = "bill_id")),
        @AssociationOverride(name = "pk.unit", joinColumns = @JoinColumn(name = "unit_id"))
})
public class BillDetail {

    @EmbeddedId
    private BillDetailId pk = new BillDetailId();

    @Column(name = "quantity")
    private Integer quantity;

    @Transient
    public Unit getUnit(){
        return pk.getUnit();
    }

    public void setUnit(Unit unit){
        pk.setUnit(unit);
    }

    @Transient
    public Bill getBill(){
        return pk.getBill();
    }

    public void setBill(Bill bill){
        pk.setBill(bill);
    }

    public BillDetailId getPk() {
        return pk;
    }

    public void setPk(BillDetailId pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
