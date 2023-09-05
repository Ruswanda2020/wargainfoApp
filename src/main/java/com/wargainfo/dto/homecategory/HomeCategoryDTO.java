package com.wargainfo.dto.homecategory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class HomeCategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7663907451301731620L;
    private String code;
    private String name;
    private Double landArea;
    private Double buildingArea;
    private Double feeAmount;

}
