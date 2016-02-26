package com.gem.nhom1.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by phuong on 1/20/2016.
 */
@Embeddable
public class UnitDealerId implements Serializable
{
    @Column(name = "unit_id")
    private int unitId;

    @Column(name = "dealer_id")
    private int dealerId;

    public UnitDealerId() {
    }

    public UnitDealerId(int unitId, int dealerId) {
        this.unitId = unitId;
        this.dealerId = dealerId;
    }

    public int getUnitId() {
        return unitId;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitDealerId that = (UnitDealerId) o;
        return unitId == that.unitId && dealerId == that.dealerId;
    }

    @Override
    public int hashCode() {
        int result = unitId;
        result = 31 * result + dealerId;
        return result;
    }
}
