package com.clinicmanagement.Services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clinicmanagement.exception.ResourceNotFoundException;
import com.clinicmanagement.model.Appointment;
import com.clinicmanagement.model.Doctor;
import com.clinicmanagement.model.Patient;
import com.clinicmanagement.repository.AppointmentRepository;
import com.clinicmanagement.repository.DoctorRepository;
import com.clinicmanagement.repository.PatientRepository;

@Service
public class AppointmentService {
    private final AppointmentRepository repo;
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;

    public AppointmentService(AppointmentRepository repo, PatientRepository patientRepo, DoctorRepository doctorRepo){
        this.repo = repo;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
    }

    public Appointment create(Appointment a){
        // validate existence
        Patient p = patientRepo.findById(a.getPatient().getId()).orElseThrow(() -> new ResourceNotFoundException("Patient", a.getPatient().getId()));
        Doctor d = doctorRepo.findById(a.getDoctor().getId()).orElseThrow(() -> new ResourceNotFoundException("Doctor", a.getDoctor().getId()));
        a.setPatient(p);
        a.setDoctor(d);
        return repo.save(a);
    }

    public List<Appointment> getAll(){ return repo.findAll(); }

    public Appointment getById(Long id){
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", id));
    }

    public Appointment update(Long id, Appointment updated){
        Appointment ap = getById(id);
        if(updated.getAppointmentTime() != null) ap.setAppointmentTime(updated.getAppointmentTime());
        if(updated.getReason() != null) ap.setReason(updated.getReason());
        // if patient/doctor changed - validate
        if(updated.getPatient() != null){
            Patient p = patientRepo.findById(updated.getPatient().getId()).orElseThrow(() -> new ResourceNotFoundException("Patient", updated.getPatient().getId()));
            ap.setPatient(p);
        }
        if(updated.getDoctor() != null){
            Doctor d = doctorRepo.findById(updated.getDoctor().getId()).orElseThrow(() -> new ResourceNotFoundException("Doctor", updated.getDoctor().getId()));
            ap.setDoctor(d);
        }
        return repo.save(ap);
    }

    public void delete(Long id){ repo.deleteById(id); }

    public List<Appointment> getByDoctor(Long doctorId){ return repo.findByDoctorId(doctorId); }
    public List<Appointment> getByPatient(Long patientId){ return repo.findByPatientId(patientId); }
}
