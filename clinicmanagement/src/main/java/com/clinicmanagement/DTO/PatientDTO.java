package com.clinicmanagement.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PatientDTO {
    private Long id;

    @NotBlank
    private String name;
    private Integer age;

    @Pattern(regexp="^\\d{10}$", message="Contact must be 10 digits")
    private String contactNumber;
    private String address;

    // getters & setters
}

