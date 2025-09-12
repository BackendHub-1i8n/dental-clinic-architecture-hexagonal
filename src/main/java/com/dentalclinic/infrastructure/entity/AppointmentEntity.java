package com.dentalclinic.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;
    @Column(name = "appointment_date_time", nullable = false)
    private LocalDateTime appointmentDateTime;
    @Column(name = "date", nullable = false)
    private Date date;

    @PrePersist
    public void prePersist() {
        this.appointmentDateTime = LocalDateTime.now();
        this.date = new Date();
    }
}
