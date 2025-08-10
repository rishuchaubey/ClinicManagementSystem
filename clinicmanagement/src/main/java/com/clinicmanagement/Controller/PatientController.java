package com.clinicmanagement.Controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicmanagement.Services.PatientService;
import com.clinicmanagement.model.Patient;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<Patient> create(@Valid @RequestBody Patient p){
        return ResponseEntity.ok(service.create(p));
    }

    @GetMapping
    public List<Patient> getAll(){ return service.getAll(); }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id){ return service.getById(id); }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @Valid @RequestBody Patient p){ return service.update(id, p); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){ service.delete(id); return ResponseEntity.noContent().build(); }
}

