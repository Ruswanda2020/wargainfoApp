package com.wargainfo.controller;

import com.wargainfo.dto.homecategory.HomeCategoryDTO;
import com.wargainfo.entity.HomeCategory;
import com.wargainfo.service.HomeCategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/homecategory")
public class HomeCategoryResource {

    private final HomeCategoryService homeCategoryService;

    @PostMapping
    public ResponseEntity<Void> createNewHomeCategory(@RequestBody @Valid HomeCategoryDTO dto){
        homeCategoryService.createNewHomeCategory(dto);
        return ResponseEntity.created(URI.create("/v1/api/homecategory")).build();
    }
    @GetMapping("/{code}")
    public ResponseEntity<HomeCategory> findHomeCategoryById(@PathVariable String code){
        return ResponseEntity.ok().body(homeCategoryService.findHomeCategoryByCode(code));
    }

    @PutMapping("/{secureId}")
    public ResponseEntity<Void> updateHomeCategory(@PathVariable String secureId, @RequestBody HomeCategoryDTO dto){
        homeCategoryService.updateHomeCategory(secureId,dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHomeCategory(@PathVariable String id){
        homeCategoryService.deleteHomeCategory(id);
        return ResponseEntity.ok().build();

    }


}
