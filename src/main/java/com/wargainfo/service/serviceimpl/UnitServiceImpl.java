package com.wargainfo.service.serviceimpl;

import com.wargainfo.dto.unit.UnitCreateRequestDTO;
import com.wargainfo.dto.unit.UnitDetailResponseDTO;
import com.wargainfo.entity.HomeCategory;
import com.wargainfo.entity.Unit;
import com.wargainfo.exception.ResourceNotFound;
import com.wargainfo.repository.UnitRepository;
import com.wargainfo.service.HomeCategoryService;
import com.wargainfo.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService{

    private final UnitRepository unitRepository;
    private final HomeCategoryService homeCategoryService;

    @Override
    public void createNewUnit(UnitCreateRequestDTO dto) {

        HomeCategory homeCategory = homeCategoryService.findHomeCategoryByCode(dto.getHomeCategory());
        Unit unit = new Unit();
        unit.setHousingBlock(dto.getHousingBlock());
        unit.setHouseNumber(dto.getHouseNumber());
        unit.setOwner(dto.getOwner());
        unit.setResidentName(dto.getResidentName());
        unit.setRt(dto.getRt());
        unit.setHomeCategory(homeCategory);

        unitRepository.save(unit);
    }
    @Override
    public UnitDetailResponseDTO findUnitDetailById(String secureId) {
        Unit unit = unitRepository.findBySecureId(secureId).orElseThrow(()-> new ResourceNotFound("Record not found"));

        UnitDetailResponseDTO dto = new UnitDetailResponseDTO();
        dto.setUnitId(unit.getSecureId());
        dto.setHouseNumber(unit.getHouseNumber());
        dto.setHousingBlock(unit.getHousingBlock());
        dto.setOwner(unit.getOwner());
        dto.setResidentName(unit.getResidentName());
        dto.setRt(unit.getRt());
        dto.setCategory(homeCategoryService.constructDTO(unit.getHomeCategory()));
        return dto;
    }
}
