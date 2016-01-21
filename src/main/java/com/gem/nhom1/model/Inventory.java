package com.gem.nhom1.model;

import javax.persistence.*;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.inventory", cascade = CascadeType.ALL)
    private Set<InventoryUnit> inventoryUnits;

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

    public Inventory(int inventoryId, String name, String address, Dealer dealer, Set<InventoryUnit> inventoryUni) {
        this.inventoryId = inventoryId;
        this.name = name;
        this.address = address;
        this.dealer = dealer;
        this.inventoryUnits = inventoryUni;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    public int getInventoryId() {
        return inventoryId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    @ManyToOne
    @JoinColumn(name = "dealer_id" , nullable = false)
    public Dealer getDealer() {
        return dealer;
    }

    public Set<InventoryUnit> getInventoryUni() {
        return inventoryUnits;
    }

    public void setInventoryUni(Set<InventoryUnit> inventoryUni) {
        this.inventoryUnits = inventoryUni;
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