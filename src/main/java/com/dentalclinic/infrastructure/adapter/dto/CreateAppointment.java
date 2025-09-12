package com.dentalclinic.infrastructure.adapter.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class CreateAppointment {
    @NotBlank(message = "Patient ID is required")
    private UUID patientId;

    public CreateAppointment() {
    }

    public CreateAppointment(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }
}
