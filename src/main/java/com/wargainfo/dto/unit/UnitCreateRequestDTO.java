package com.wargainfo.dto.unit;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UnitCreateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 862866977435702335L;

    private String housingBlock;

    private Integer houseNumber;

    private String owner;

    private String residentName;

    private Integer rt;

    private String homeCategory;


}
