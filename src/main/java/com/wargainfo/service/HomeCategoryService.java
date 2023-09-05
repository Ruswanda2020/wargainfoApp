package com.wargainfo.service;

import com.wargainfo.dto.homecategory.HomeCategoryDTO;
import com.wargainfo.entity.HomeCategory;

public interface HomeCategoryService {

    public void createNewHomeCategory(HomeCategoryDTO dto);

    public HomeCategory findHomeCategoryByCode(String code);

    public void updateHomeCategory(String id, HomeCategoryDTO dto);

    public void deleteHomeCategory(String id);

    public HomeCategory findByName(String name);
}
