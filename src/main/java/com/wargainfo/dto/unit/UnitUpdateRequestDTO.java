package com.wargainfo.dto.unit;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UnitUpdateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5645090081928639216L;

    private String owner;

    private String residentName;

    private String homeCategory;
}
