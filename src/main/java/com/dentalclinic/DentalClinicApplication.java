package com.dentalclinic;

import com.dentalclinic.application.ListAppointment;
import com.dentalclinic.domain.port.AppointmentRepository;
import com.dentalclinic.domain.port.PatientRepository;
import com.dentalclinic.domain.service.AppointmentService;
import com.dentalclinic.domain.service.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DentalClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DentalClinicApplication.class, args);
    }

    @Bean
    public AppointmentService getAppointmentService(AppointmentRepository appointmentRepository) {
        return new AppointmentService(appointmentRepository);
    }

    @Bean
    public PatientService getPatientService(PatientRepository patientRepository) {
        return new PatientService(patientRepository);
    }

    @Bean
    public ListAppointment getListAppointment(AppointmentRepository appointmentRepository) {
        return new ListAppointment(appointmentRepository);
    }

}
