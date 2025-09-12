package com.dentalclinic.infrastructure.adapter.mapper;

import com.dentalclinic.domain.model.Patient;
import com.dentalclinic.infrastructure.adapter.dto.CreatePatient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientDtoMapper {
    CreatePatient toDto(Patient patient);
    Patient toModel(CreatePatient createPatientDto);
}
