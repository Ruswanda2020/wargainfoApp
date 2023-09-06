package com.wargainfo.dto.unit;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.wargainfo.dto.homecategory.HomeCategoryDTO;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class UnitDetailResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6392408056440649211L;

    private String unitId;
    private String housingBlock;
    private Integer houseNumber;
    private String owner;
    private String residentName;
    private Integer rt;
    private HomeCategoryDTO category;


}
