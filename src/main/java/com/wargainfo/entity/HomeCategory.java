package com.wargainfo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "home_category")
public class HomeCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = -1339658412692599444L;

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "land_area" ,nullable = false)
    private Double landArea;

    @Column(name = "building_area", nullable = false)
    private Double buildingArea;

    @Column(name = "fee_amount",nullable = false)
    private Double feeAmount;

    @OneToMany(mappedBy = "homeCategory")
    private List<Unit> units;

}
