# 🦷 Sistema de Citas - Clínica Dental

Este proyecto es un **sistema de gestión de citas** para la clínica dental.
El objetivo principal es **poner en práctica la arquitectura hexagonal** con **Spring Boot (Java)**, asegurando que la aplicación sea **modular, extensible y fácil de mantener**.

---

## 📌 Objetivos del Proyecto

* Implementar un sistema básico para **registrar y gestionar citas** de pacientes.
* Practicar el uso de la **arquitectura hexagonal** dividiendo la aplicación en:

    * **Dominio** → Reglas de negocio y modelos.
    * **Aplicación** → Casos de uso.
    * **Infraestructura** → Adaptadores (API REST, persistencia, etc).
* Preparar la base para futuras extensiones como gestión de pacientes, pagos, inventario y notificaciones.

---

## 🏗️ Arquitectura Hexagonal

La estructura de carpetas del proyecto es la siguiente:

```
src/main/java/com/dentalclinic
│   DentalClinicApplication.java
│   
├───application
│       ListAppointment.java
│       
├───domain
│   ├───model
│   │       Appointment.java
│   │       Patient.java
│   │       
│   ├───port
│   │       AppointmentRepository.java
│   │       PatientRepository.java
│   │       
│   └───service
│           AppointmentService.java
│           PatientService.java
│           
├───infrastructure
│   ├───adapter
│   │   ├───controller
│   │   │       AppointmentController.java
│   │   │       GlobalExceptionHandler.java
│   │   │       PatientController.java
│   │   │       
│   │   ├───dto
│   │   │       CreateAppointment.java
│   │   │       CreatePatient.java
│   │   │       
│   │   ├───mapper
│   │   │       AppointmentDtoMapper.java
│   │   │       PatientDtoMapper.java
│   │   │       
│   │   ├───repository
│   │   │       AppointmentJpaRepository.java
│   │   │       PatientJpaRepository.java
│   │   │       
│   │   └───services
│   │           AppointmentService.java
│   │           PatientService.java
│   │           
│   └───entity
│           AppointmentEntity.java
│           PatientEntity.java
│           
└───types
        BaseRepository.java
```

* **Dominio** → Lógica del negocio (qué es una cita y cómo funciona).
* **Aplicación** → Casos de uso (ej: listar citas).
* **Infraestructura** → Implementaciones concretas (API REST, JPA, DB).

---

## 🚀 Tecnologías utilizadas

* **Java 21**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL** (base de datos)
* **Maven**

---

## ⚙️ Requisitos previos

* Tener instalado:

    * JDK 21
    * Maven 3+
    * PostgreSQL (con una base de datos creada, ej: `dentalclinic`)

---

## ▶️ Ejecución del proyecto

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/dental-clinic.git
   cd dental-clinic
   ```

2. Configurar la conexión a la base de datos en `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/dentalclinic
   spring.datasource.username=postgres
   spring.datasource.password=tu_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Compilar y ejecutar:

   ```bash
   mvn spring-boot:run
   ```

4. La API estará disponible en:

   ```
   http://localhost:8080/api/citas
   ```

---

## 📖 Endpoints iniciales

* **POST /api/citas** → Registrar una nueva cita.
* **GET /api/citas** → Listar todas las citas.

---

## 🔮 Próximos pasos

* Validaciones en DTOs con `jakarta.validation`.
* Manejo global de excepciones con `@ControllerAdvice`.
* Agregar autenticación y autorización (Spring Security).
* Extender el sistema a pacientes, pagos e inventario.

---