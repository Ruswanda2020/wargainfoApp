package com.wargainfo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
@Entity
@Data
@Table(name = "home_category")
public class HomeCategory extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -1339658412692599444L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "land_area" ,nullable = false)
    private Double landArea;

    @Column(name = "building_area", nullable = false)
    private Double buildingArea;

    @Column(name = "fee_amount",nullable = false)
    private Double feeAmount;
}
