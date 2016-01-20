package com.gem.nhom1.model;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by vanhop on 1/18/16.
 */
@Entity
@Table(name = "UNITS")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_ID")
    private Integer unitId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "IS_PART")
    private Integer isPart;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="PART_OF")
    private Unit partOf;

    @OneToMany(mappedBy = "partOf")
    private Set<Unit> units;


    public Unit() {
    }

    public Unit(String type, Integer isPart) {
        this.type = type;
        this.isPart = isPart;
    }



    public void setType(String type) {
        this.type = type;
    }

    public void setIsPart(Integer isPart) {
        this.isPart = isPart;
    }

    public Unit getPartOf() {
        return partOf;
    }

    public void setPartOf(Unit partOf) {
        this.partOf = partOf;
    }

    public void setUnits(Set<Unit> units) {
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public Integer getIsPart() {
        return isPart;
    }


    public Set<Unit> getUnits() {
        return units;
    }
}