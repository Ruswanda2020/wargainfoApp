package com.wargainfo.controller;

import com.wargainfo.dto.unit.UnitCreateRequestDTO;
import com.wargainfo.dto.unit.UnitDetailResponseDTO;
import com.wargainfo.dto.unit.UnitUpdateRequestDTO;
import com.wargainfo.service.UnitService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/unit")
public class UnitResource {

    private final UnitService unitService;

    @PostMapping
    public ResponseEntity<Void> createNewUnit(@RequestBody @Valid UnitCreateRequestDTO dto){
        unitService.createNewUnit(dto);
        return ResponseEntity.created(URI.create("/v1/api/unit")).build();
    }
    @GetMapping("/{secureId}")
    public ResponseEntity<UnitDetailResponseDTO> findUnitByCode(@PathVariable String secureId){
        UnitDetailResponseDTO result = unitService.findUnitDetailById(secureId);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{secureId}")
    public ResponseEntity<Void> updateUnit(@PathVariable String secureId, @RequestBody UnitUpdateRequestDTO dto){
        unitService.updateUnit(secureId,dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable String id){
        unitService.deleteUnit(id);
        return ResponseEntity.ok().build();
    }
}
