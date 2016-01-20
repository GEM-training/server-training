package com.gem.nhom1.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Created by phuongtd on 20/01/2016.
 */

@Embeddable
public class BillDetailId {
    @ManyToOne
    private Bill bill;
    @ManyToOne
    private Unit unit;


    public Bill getBill() {
        return bill;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillDetailId that = (BillDetailId) o;

        if (bill != null ? !bill.equals(that.bill) : that.bill != null) return false;
        return unit != null ? unit.equals(that.unit) : that.unit == null;

    }

    @Override
    public int hashCode() {
        int result = bill != null ? bill.hashCode() : 0;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
