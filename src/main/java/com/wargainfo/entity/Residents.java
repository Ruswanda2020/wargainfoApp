package com.wargainfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "residents")
public class Residents extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -4651402564542127242L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "religion", nullable = false)
    private String religion;

    @Column(name = "profession")
    private String profession;

    @Column(name = "birth_day", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    @Column(name = "birth_place")
    private String birthPlace;

    @Email(message = "Email is not valid", regexp = "{(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])}")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Column(name = "id_card_number")
    private String idCardNumber;

    @Column(name = "house_hold_head",nullable = false)
    private Boolean householdHead;

    @OneToOne
    @JoinColumn(name = "unit")
    private Unit unit;


}
