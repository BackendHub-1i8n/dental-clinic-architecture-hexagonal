package com.dentalclinic.infrastructure.adapter.services;

import com.dentalclinic.domain.model.Patient;
import com.dentalclinic.domain.port.PatientRepository;
import com.dentalclinic.infrastructure.adapter.repository.PatientJpaRepository;
import com.dentalclinic.infrastructure.entity.PatientEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService implements PatientRepository {
    private final PatientJpaRepository patientJpaRepository;

    public PatientService(PatientJpaRepository patientJpaRepository) {
        this.patientJpaRepository = patientJpaRepository;
    }

    @Override
    public Patient save(Patient entity) {
        PatientEntity patient = new PatientEntity();
        patient.setName(entity.getName());
        patient.setEmail(entity.getEmail());
        patient.setPhoneNumber(entity.getPhoneNumber());

        this.patientJpaRepository.save(patient);
        return entity;
    }

    @Override
    public List<Patient> findAll() {
        return this.patientJpaRepository.findAll().stream().map(patientEntity -> {;
            Patient patient = new Patient();
            patient.setId(patientEntity.getId());
            patient.setName(patientEntity.getName());
            patient.setEmail(patientEntity.getEmail());
            patient.setPhoneNumber(patientEntity.getPhoneNumber());
            return patient;
        }).parallel().toList();
    }

    @Override
    public void deleteById(UUID id) {
        this.patientJpaRepository.deleteById(id);
    }

    @Override
    public Optional<?> findById(UUID id) {
        return this.patientJpaRepository.findById(id);
    }

    @Override
    public void update(Patient entity, UUID id) {

    }

    @Override
    public Patient findByUser(UUID userId) {
            PatientEntity curr = this.patientJpaRepository.findById(userId).orElse(null);
            Patient patient = new Patient();
            if (curr != null) {
                patient.setId(curr.getId());
                patient.setName(curr.getName());
                patient.setEmail(curr.getEmail());
                patient.setPhoneNumber(curr.getPhoneNumber());
            }
            return patient;
    }
}
