package com.clinicmanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicmanagement.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {}
