package com.wargainfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
@Entity
@Data
@Table(name = "unit")
public class Unit extends AbstractBaseEntity{

    @Serial
    private static final long serialVersionUID = -8671171555251088567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "housing_block",nullable = false)
    private String housingBlock;

    @Column(name = "house_number",unique = true,nullable = false)
    private Integer houseNumber;

    @Column(name = "owner",nullable = false)
    private String owner;

    @Column(name = "resident_name",nullable = false)
    private String residentName;

    @Column(name = "rt",nullable = false)
    private Integer rt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_category", nullable = false)
    private HomeCategory homeCategory;
}
