package com.clinicmanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicmanagement.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	
}
