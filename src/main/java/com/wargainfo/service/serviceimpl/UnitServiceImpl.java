package com.wargainfo.service.serviceimpl;

import com.wargainfo.dto.UnitCreateRequestDTO;
import com.wargainfo.entity.HomeCategory;
import com.wargainfo.entity.Unit;
import com.wargainfo.repository.UnitRepository;
import com.wargainfo.service.HomeCategoryService;
import com.wargainfo.service.UnitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
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
}
