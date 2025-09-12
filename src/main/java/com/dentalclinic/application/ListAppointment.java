package com.dentalclinic.application;

import com.dentalclinic.domain.model.Appointment;
import com.dentalclinic.domain.port.AppointmentRepository;

import java.util.List;
import java.util.UUID;

public class ListAppointment {

    private final AppointmentRepository appointmentRepository;

    public ListAppointment(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<?> findAll() {
        return this.appointmentRepository.findAll();
    }

    public Appointment findByUser(UUID userId){
        return this.appointmentRepository.findByUser(userId);
    }

}
