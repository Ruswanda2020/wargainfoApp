package com.wargainfo.service;

import com.wargainfo.dto.homecategory.HomeCategoryDTO;
import com.wargainfo.entity.HomeCategory;

import java.util.Optional;

public interface HomeCategoryService {

    public void createNewHomeCategory(HomeCategoryDTO dto);

    public HomeCategory findHomeCategoryById(String id);

    public void updateHomeCategory(String id, HomeCategoryDTO dto);

    public void deleteHomeCategory(String id);

    public HomeCategory findByName(String name);
}
