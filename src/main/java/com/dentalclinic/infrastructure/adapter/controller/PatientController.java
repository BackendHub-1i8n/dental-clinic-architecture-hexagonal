package com.dentalclinic.infrastructure.adapter.controller;

import com.dentalclinic.domain.model.Patient;
import com.dentalclinic.domain.service.PatientService;
import com.dentalclinic.infrastructure.adapter.dto.CreatePatient;
import com.dentalclinic.infrastructure.adapter.mapper.PatientDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    private final PatientDtoMapper patientDtoMapper;
    public PatientController(PatientService patientService, PatientDtoMapper patientDtoMapper) {
        this.patientService = patientService;
        this.patientDtoMapper = patientDtoMapper;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CreatePatient createPatient) {
        Patient entity = this.patientDtoMapper.toModel(createPatient);
        return ResponseEntity.ok().body(this.patientService.save(entity));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        try{
            List<Patient> patients = this.patientService.findAll();
            if (patients.isEmpty()) {
                return ResponseEntity.status(404).body("No patients found");
            }
            return ResponseEntity.ok().body(patients);
        }catch(Exception e){
            return ResponseEntity.internalServerError().body("Error fetching patients   : " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try{
            Patient patient = (Patient) this.patientService.findById(id).orElse(null);
            if (patient != null) {
                return ResponseEntity.ok().body(patient);
            } else {
                return ResponseEntity.status(404).body("Patient not found");
            }
        }catch(Exception e){
            return ResponseEntity.status(404).body("Patient not found");
        }
    }
}
