package com.wargainfo.service;

import com.wargainfo.dto.unit.UnitCreateRequestDTO;
import com.wargainfo.dto.unit.UnitDetailResponseDTO;
import com.wargainfo.dto.unit.UnitUpdateRequestDTO;
import com.wargainfo.entity.Unit;

public interface UnitService {

    public void createNewUnit(UnitCreateRequestDTO dto);

    public UnitDetailResponseDTO findUnitDetailById(Long secureId);

    public void updateUnit(Long secureId, UnitUpdateRequestDTO dto);

    public void deleteUnit(Long id);

    public Unit findUnitById(Long id);
}
