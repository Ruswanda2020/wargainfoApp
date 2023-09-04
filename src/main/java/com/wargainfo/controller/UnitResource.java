package com.wargainfo.controller;

import com.wargainfo.dto.UnitCreateRequestDTO;
import com.wargainfo.service.UnitService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
