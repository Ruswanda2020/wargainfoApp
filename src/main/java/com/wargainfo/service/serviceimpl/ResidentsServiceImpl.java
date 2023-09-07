package com.wargainfo.service.serviceimpl;

import com.wargainfo.dto.residents.ResidentsCreateRequestDTO;
import com.wargainfo.entity.Residents;
import com.wargainfo.entity.Unit;
import com.wargainfo.exception.ResourceNotFound;
import com.wargainfo.repository.ResidentsRepository;
import com.wargainfo.service.ResidentsService;
import com.wargainfo.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResidentsServiceImpl implements ResidentsService {

    private final ResidentsRepository residentsRepository;

    private final UnitService unitService;

    @Override
    public void createNewResidents(ResidentsCreateRequestDTO dto) {

        Unit unit = unitService.findUnitById(dto.getUnitId());

        Residents residents = new Residents();
        residents.setName(dto.getName());
        residents.setBirthDay(dto.getBirthDay());
        residents.setBirthPlace(dto.getBirthPlace());
        residents.setReligion(dto.getReligion());
        residents.setProfession(dto.getProfession());
        residents.setHouseholdHead(dto.getHouseholdHead());
        residents.setIdCardNumber(dto.getIdCardNumber());
        residents.setMemberOf(dto.getMemberOf());
        residents.setEmail(dto.getEmail());
        residents.setUnit(unit);

        residentsRepository.save(residents);

    }
    @Override
    public void deleteResidents(String secureId) {
        Residents residents = residentsRepository.findBySecureId(secureId)
                .orElseThrow(()-> new ResourceNotFound("Record not found"));
        residentsRepository.delete(residents);
    }
}
