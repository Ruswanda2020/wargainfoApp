package com.wargainfo.dto.residents;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResidentsCreateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 3416417430466602021L;

    private String name;

    private String profession;

    private String religion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    private String birthPlace;

    @Email
    private String email;


    private String idCardNumber;

    private Boolean householdHead;

    private Long memberOf;

    private String unitId;


}
