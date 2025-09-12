package com.dentalclinic.infrastructure.adapter.services;

import com.dentalclinic.domain.model.Appointment;
import com.dentalclinic.domain.port.AppointmentRepository;
import com.dentalclinic.infrastructure.adapter.repository.AppointmentJpaRepository;
import com.dentalclinic.infrastructure.entity.AppointmentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService implements AppointmentRepository {
    private final AppointmentJpaRepository appointmentJpaRepository;

    public AppointmentService(AppointmentJpaRepository appointmentJpaRepository) {
        this.appointmentJpaRepository = appointmentJpaRepository;
    }

    @Override
    public Appointment save(Appointment entity) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setDate(entity.getDate());
        appointmentEntity.setDate(entity.getDate());
        appointmentEntity.setPatientId(entity.getPatientId());
        this.appointmentJpaRepository.save(appointmentEntity);
        return entity;
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentJpaRepository.findAll().stream().map(appointmentEntity -> {
            Appointment appointment = new Appointment();
            appointment.setId(appointmentEntity.getId());
            appointment.setDate(appointmentEntity.getDate());
            appointment.setAppointmentDateTime(appointmentEntity.getAppointmentDateTime());
            appointment.setPatientId(appointmentEntity.getPatientId());
            return appointment;
        }).toList();
    }

    @Override
    public void deleteById(UUID id) {
        this.appointmentJpaRepository.deleteById(id);
    }

    @Override
    public Optional<?> findById(UUID id) {
        return this.appointmentJpaRepository.findById(id);
    }

    @Override
    public void update(Appointment entity, UUID id) {}

    @Override
    public Appointment findByUser(UUID userId) {
        AppointmentEntity curr = this.appointmentJpaRepository.findByPatientId(userId);
        Appointment appointment = new Appointment();
        appointment.setId(curr.getId());
        appointment.setDate(curr.getDate());
        appointment.setAppointmentDateTime(curr.getAppointmentDateTime());
        appointment.setPatientId(curr.getPatientId());
        return appointment;
    }
}
