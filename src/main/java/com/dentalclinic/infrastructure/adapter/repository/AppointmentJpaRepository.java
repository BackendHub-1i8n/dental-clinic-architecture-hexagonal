package com.dentalclinic.infrastructure.adapter.repository;

import com.dentalclinic.infrastructure.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentJpaRepository extends JpaRepository<AppointmentEntity, UUID> {
    AppointmentEntity findByPatientId(UUID patientId);
}
