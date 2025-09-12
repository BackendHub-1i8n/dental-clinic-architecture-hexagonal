package com.dentalclinic.domain.service;

import com.dentalclinic.domain.model.Appointment;
import com.dentalclinic.domain.port.AppointmentRepository;
import com.dentalclinic.types.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AppointmentService implements BaseRepository<Appointment> {
    private  final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Appointment save(Appointment entity) {
        return this.appointmentRepository.save(entity);
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        this.appointmentRepository.deleteById(id);
    }

    @Override
    public Optional<?> findById(UUID id) {
        return this.appointmentRepository.findById(id);
    }

    @Override
    public void update(Appointment entity, UUID id) {
        this.appointmentRepository.update(entity, id);
    }

    @Override
    public Appointment findByUser(UUID userId) {
        return this.appointmentRepository.findByUser(userId);
    }
}
