package com.clinicmanagement.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicmanagement.model.Appointment;
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByPatientId(Long patientId);
}
