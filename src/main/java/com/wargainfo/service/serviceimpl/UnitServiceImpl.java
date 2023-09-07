package com.wargainfo.service.serviceimpl;

import com.wargainfo.dto.unit.UnitCreateRequestDTO;
import com.wargainfo.dto.unit.UnitDetailResponseDTO;
import com.wargainfo.dto.unit.UnitUpdateRequestDTO;
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
    public UnitDetailResponseDTO findUnitDetailById(Long id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("RECORD NOT FOUND"));

        UnitDetailResponseDTO dto = new UnitDetailResponseDTO();
        dto.setHouseNumber(unit.getHouseNumber());
        dto.setHousingBlock(unit.getHousingBlock());
        dto.setOwner(unit.getOwner());
        dto.setResidentName(unit.getResidentName());
        dto.setRt(unit.getRt());
        dto.setCategory(homeCategoryService.constructDTO(unit.getHomeCategory()));
        return dto;
    }

    @Override
    public void updateUnit(Long id, UnitUpdateRequestDTO dto) {
        Unit unit = unitRepository.findById(id).
                orElseThrow(()-> new ResourceNotFound("Record not Found"));
        unit.setResidentName(dto.getResidentName());
        unit.setOwner(dto.getOwner());
        unitRepository.save(unit);
    }

    @Override
    public void deleteUnit(Long id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Record not found"));
        unitRepository.delete(unit);

    }

    @Override
    public Unit findUnitById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Record not found"));
    }
}
