package com.wargainfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

    @Email
    private String email;

    @Column(name = "id_card_number",unique = true)
    private String idCardNumber;

    @Column(name = "house_hold_head")
    private Boolean householdHead;

    @Column(name = "member_of")
    private Long memberOf;

    @OneToOne
    @JoinColumn(name = "unit")
    private Unit unit;


}
