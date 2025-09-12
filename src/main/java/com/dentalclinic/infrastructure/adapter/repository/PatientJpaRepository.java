package com.dentalclinic.infrastructure.adapter.repository;

import com.dentalclinic.infrastructure.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientJpaRepository extends JpaRepository<PatientEntity, UUID> {
}
