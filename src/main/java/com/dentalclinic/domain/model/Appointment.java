package com.dentalclinic.domain.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Appointment {
    private UUID id;
    private UUID patientId;
    private LocalDateTime appointmentDateTime;
    private Date date;

    public Appointment(UUID id, UUID patientId) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentDateTime = LocalDateTime.now();
        this.date = new Date();
    }

    public Appointment() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
