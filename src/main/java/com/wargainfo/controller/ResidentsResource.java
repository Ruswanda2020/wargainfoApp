package com.wargainfo.controller;

import com.wargainfo.dto.residents.ResidentsCreateRequestDTO;
import com.wargainfo.service.ResidentsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/residents")
public class ResidentsResource {

    private final ResidentsService residentsService;

    @PostMapping
    public ResponseEntity<Void> createNewResidents(@RequestBody @Valid ResidentsCreateRequestDTO dto){
       residentsService.createNewResidents(dto);
       return ResponseEntity.created(URI.create("/v1/api/residents")).build();
    }

    @DeleteMapping("/{secureId}")
    public ResponseEntity<Void> deleteResidents(@PathVariable String secureId){
        residentsService.deleteResidents(secureId);
        return ResponseEntity.ok().build();
    }


}
