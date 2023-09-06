package com.wargainfo.service;

import com.wargainfo.dto.unit.UnitCreateRequestDTO;
import com.wargainfo.dto.unit.UnitDetailResponseDTO;

public interface UnitService {

    public void createNewUnit(UnitCreateRequestDTO dto);

    public UnitDetailResponseDTO findUnitDetailById(String secureId);
}
