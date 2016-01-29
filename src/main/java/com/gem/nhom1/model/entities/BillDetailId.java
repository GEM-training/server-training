package com.gem.nhom1.model.entities;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by vanhop on 1/20/16.
 */

@Embeddable
public class BillDetailId implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Unit unit;

    public BillDetailId() {
    }

    public BillDetailId(Bill bill, Unit unit) {
        this.bill = bill;
        this.unit = unit;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
