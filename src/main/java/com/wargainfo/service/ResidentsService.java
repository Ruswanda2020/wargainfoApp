package com.wargainfo.service;

import com.wargainfo.dto.residents.ResidentsCreateRequestDTO;

public interface ResidentsService {

    public void createNewResidents(ResidentsCreateRequestDTO dto);

    public void deleteResidents(String secureId);
}
