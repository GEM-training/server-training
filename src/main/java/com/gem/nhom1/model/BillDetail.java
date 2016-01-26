package com.gem.nhom1.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

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
    @JsonIgnore
    private BillDetailId pk = new BillDetailId();

    @Min(value = 0, message = "Không được nhập gía trị âm")
    @Digits(integer = 10, fraction = 0, message = "Giá trị truyền vào quá lớn")
    @Column(name = "quantity")
    private Integer quantity;

    public BillDetail(BillDetailId pk, Integer quantity) {
        this.pk = pk;
        this.quantity = quantity;
    }

    public BillDetail() {
    }

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
