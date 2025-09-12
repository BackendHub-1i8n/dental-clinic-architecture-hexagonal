package com.dentalclinic.infrastructure.adapter.mapper;

import com.dentalclinic.domain.model.Appointment;
import com.dentalclinic.infrastructure.adapter.dto.CreateAppointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentDtoMapper {
    CreateAppointment toDto(Appointment appointment);
    Appointment toModel(CreateAppointment createAppointmentDto);
}
