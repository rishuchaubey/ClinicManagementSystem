package com.clinicmanagement.DTO;


import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AppointmentDTO {
    private Long id;
    @NotNull
    private Long patientId;
    @NotNull
    private Long doctorId;
    @NotNull
    private LocalDateTime appointmentTime;
    private String reason;
    // getters & setters
}
