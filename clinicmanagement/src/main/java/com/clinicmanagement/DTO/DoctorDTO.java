package com.clinicmanagement.DTO;


import jakarta.validation.constraints.NotBlank;

public class DoctorDTO {
    private Long id;
    @NotBlank
    private String name;
    private String specialization;
    private String contactNumber;
    // getters & setters
}

