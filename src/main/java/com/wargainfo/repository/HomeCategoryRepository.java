package com.wargainfo.repository;

import com.wargainfo.entity.HomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeCategoryRepository extends JpaRepository<HomeCategory, String> {

    Optional<HomeCategory> findBySecureId(String id);
    HomeCategory findByName(String name);
}
