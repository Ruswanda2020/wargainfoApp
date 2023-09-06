package com.wargainfo.repository;

import com.wargainfo.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Optional<Unit>findBySecureId( String secureId);

}
