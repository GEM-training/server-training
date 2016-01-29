package com.gem.nhom1.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by phuong on 1/19/2016.
 */
@Entity
@Table(name = "inventorys")
public class Inventory {

    private int inventoryId;
    private String name;
    private String address;

    private Dealer dealer;



    private Set<InventoryUnit> inventoryUnits = new HashSet<InventoryUnit>();

    public Inventory() {
    }

    public Inventory(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Inventory(String name, String address, Dealer dealer) {
        this.name = name;
        this.address = address;
        this.dealer = dealer;
    }


    public Inventory(int inventoryId, String name, String address, Dealer dealer, Set<InventoryUnit> inventoryUnits) {
        this.inventoryId = inventoryId;
        this.name = name;
        this.address = address;
        this.dealer = dealer;
        this.inventoryUnits = inventoryUnits;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    public int getInventoryId() {
        return inventoryId;
    }

    @NotNull(message = "Tên khô không được để rỗng")
    @Length(min = 3, max = 100, message = "Tên kho có độ dài từ 3 đến 100 kí tự")
    @Column(name = "name" , length = 100 , nullable = false)
    public String getName() {
        return name;
    }

    @Length(max = 100, message = "Độ dài địa chỉ không vượt quá 100")
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    @ManyToOne
    @JoinColumn(name = "dealer_id" , nullable = false)
    @JsonIgnore
    public Dealer getDealer() {
        return dealer;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "inventoryUnitId.inventory")
    @JsonIgnore
    public Set<InventoryUnit> getInventoryUnits() {
        return inventoryUnits;
    }

    public void setInventoryUnits(Set<InventoryUnit> inventoryUnits) {
        this.inventoryUnits = inventoryUnits;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}