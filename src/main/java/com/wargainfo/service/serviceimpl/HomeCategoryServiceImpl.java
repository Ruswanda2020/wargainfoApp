package com.wargainfo.service.serviceimpl;

import com.wargainfo.dto.homecategory.HomeCategoryDTO;
import com.wargainfo.entity.HomeCategory;
import com.wargainfo.exception.ResourceNotFound;
import com.wargainfo.repository.HomeCategoryRepository;
import com.wargainfo.service.HomeCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HomeCategoryServiceImpl implements HomeCategoryService {

    private HomeCategoryRepository homeCategoryRepository;
    @Override
    public void createNewHomeCategory(HomeCategoryDTO dto) {
        HomeCategory homeCategory = new HomeCategory();
        homeCategory.setName(dto.getName());
        homeCategory.setLandArea(dto.getLandArea());
        homeCategory.setBuildingArea(dto.getBuildingArea());
        homeCategory.setFeeAmount(dto.getFeeAmount());
        homeCategoryRepository.save(homeCategory);
    }

    @Override
    public HomeCategory findHomeCategoryById(String id) {
        return homeCategoryRepository.findBySecureId(id)
                .orElseThrow(()-> new ResourceNotFound("Resource not found"));
    }

    @Override
    public void updateHomeCategory(String id, HomeCategoryDTO dto) {
        HomeCategory homeCategory = homeCategoryRepository.findBySecureId(id)
                .orElseThrow(()-> new ResourceNotFound("invalid home category id"));
        homeCategory.setName(dto.getName()==null?homeCategory.getName():dto.getName());
        homeCategory.setLandArea(dto.getLandArea()==null?homeCategory.getLandArea(): dto.getLandArea());
        homeCategory.setBuildingArea(dto.getBuildingArea()==null? homeCategory.getBuildingArea() : dto.getBuildingArea());
        homeCategory.setFeeAmount(dto.getFeeAmount()==null? homeCategory.getFeeAmount() : dto.getFeeAmount());
        homeCategoryRepository.save(homeCategory);
    }

    @Override
    public void deleteHomeCategory(String id) {
        HomeCategory homeCategory = homeCategoryRepository.findBySecureId(id)
                .orElseThrow(()-> new ResourceNotFound("record not found"));
        homeCategoryRepository.delete(homeCategory);
    }

    @Override
    public HomeCategory findByName(String name) {
        HomeCategory homeCategory = homeCategoryRepository.findByName(name);
        if (homeCategory==null){
            throw new ResourceNotFound("type name home not available");
        }
        return homeCategory;
    }
}
