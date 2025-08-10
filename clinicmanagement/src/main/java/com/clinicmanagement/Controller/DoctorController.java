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

import com.clinicmanagement.Services.DoctorService;
import com.clinicmanagement.model.Doctor;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService service;
    public DoctorController(DoctorService service){ this.service = service; }

    @PostMapping public Doctor create(@Valid @RequestBody Doctor d){ return service.create(d); }
    @GetMapping public List<Doctor> getAll(){ return service.getAll(); }
    @GetMapping("/{id}") public Doctor getById(@PathVariable Long id){ return service.getById(id); }
    @PutMapping("/{id}") public Doctor update(@PathVariable Long id, @Valid @RequestBody Doctor d){ return service.update(id, d); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}

