package com.dentalclinic.infrastructure.adapter.controller;

import com.dentalclinic.application.ListAppointment;
import com.dentalclinic.domain.model.Appointment;
import com.dentalclinic.domain.service.AppointmentService;
import com.dentalclinic.infrastructure.adapter.dto.CreateAppointment;
import com.dentalclinic.infrastructure.adapter.mapper.AppointmentDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final ListAppointment listAppointment;
    private final AppointmentDtoMapper appointmentDtoMapper;

    public AppointmentController(AppointmentService appointmentService, ListAppointment listAppointment, AppointmentDtoMapper appointmentDtoMapper) {
        this.appointmentService = appointmentService;
        this.listAppointment = listAppointment;
        this.appointmentDtoMapper = appointmentDtoMapper;
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@Valid @RequestBody CreateAppointment appointment) {
        try {
            Appointment created = this.appointmentDtoMapper.toModel(appointment);
            Appointment appointment1 = appointmentService.save(created);
            return ResponseEntity.ok().body(appointment1);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error creating appointment: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllAppointments() {
        List<Appointment> appointments = listAppointment.findAll().stream().map(appointment -> (Appointment) appointment).toList();
        try {
            if (appointments.isEmpty()) {
                return ResponseEntity.status(404).body("No appointments found");
            } else {
                return ResponseEntity.ok().body(appointments);
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error fetching appointments: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable UUID id) {
        try{
           this.appointmentService.deleteById(id);
           return ResponseEntity.ok().body("Appointment has been deleted");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error deleting appointment: " + e.getMessage());
        }
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<?> getAppointmentById(@PathVariable UUID patientId) {
        try{
            Appointment appointment = this.listAppointment.findByUser(patientId);
            if (appointment != null) {
                return ResponseEntity.ok().body(appointment);
            }
            return ResponseEntity.status(404).body("Appointment not found for patient ID: " + patientId);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error fetching appointment by ID: " + e.getMessage());
        }
    }
}
