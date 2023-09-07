package com.wargainfo.repository;

import com.wargainfo.entity.Residents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResidentsRepository extends JpaRepository<Residents, Long> {

    Optional<Residents> findBySecureId(String secureId);
}
