package com.dentalclinic.domain.service;

import com.dentalclinic.domain.model.Patient;
import com.dentalclinic.domain.port.PatientRepository;
import com.dentalclinic.types.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PatientService implements BaseRepository<Patient> {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient entity) {
        return this.patientRepository.save(entity);
    }

    @Override
    public List<Patient> findAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        this.patientRepository.deleteById(id);
    }

    @Override
    public Optional<?> findById(UUID id) {
        return this.patientRepository.findById(id);
    }

    @Override
    public void update(Patient entity, UUID id) {
        this.patientRepository.update(entity, id);
    }

    @Override
    public Patient findByUser(UUID userId) {
        return this.patientRepository.findByUser(userId);
    }
}
