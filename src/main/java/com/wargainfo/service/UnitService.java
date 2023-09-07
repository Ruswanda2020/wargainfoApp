package com.wargainfo.service;

import com.wargainfo.dto.unit.UnitCreateRequestDTO;
import com.wargainfo.dto.unit.UnitDetailResponseDTO;
import com.wargainfo.dto.unit.UnitUpdateRequestDTO;
import com.wargainfo.entity.Unit;

public interface UnitService {

    public void createNewUnit(UnitCreateRequestDTO dto);

    public UnitDetailResponseDTO findUnitDetailById(String secureId);

    public void updateUnit(String secureId, UnitUpdateRequestDTO dto);

    public void deleteUnit(String id);

    public Unit findUnitById(String secureId);
}
