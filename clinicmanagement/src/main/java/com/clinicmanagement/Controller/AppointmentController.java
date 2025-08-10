package com.clinicmanagement.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicmanagement.Services.AppointmentService;
import com.clinicmanagement.model.Appointment;
import com.clinicmanagement.repository.DoctorRepository;
import com.clinicmanagement.repository.PatientRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService service;
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;

    public AppointmentController(AppointmentService service, PatientRepository patientRepo, DoctorRepository doctorRepo){
        this.service = service;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
    }

    @PostMapping
    public Appointment create(@Valid @RequestBody Appointment request){
        // request must include patient.id and doctor.id set inside nested objects (simple approach)
        return service.create(request);
    }

    @GetMapping
    public List<Appointment> getAll(){ return service.getAll(); }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Long id){ return service.getById(id); }

    @PutMapping("/{id}")
    public Appointment update(@PathVariable Long id, @RequestBody Appointment updated){ return service.update(id, updated); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> byDoctor(@PathVariable Long doctorId){ return service.getByDoctor(doctorId); }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> byPatient(@PathVariable Long patientId){ return service.getByPatient(patientId); }
}

