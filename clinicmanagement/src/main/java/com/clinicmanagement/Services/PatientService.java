package com.clinicmanagement.Services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clinicmanagement.exception.ResourceNotFoundException;
import com.clinicmanagement.model.Patient;
import com.clinicmanagement.repository.PatientRepository;

@Service
public class PatientService {
    private final PatientRepository repo;
    public PatientService(PatientRepository repo) { this.repo = repo; }

    public Patient create(Patient p) { return repo.save(p); }
    public List<Patient> getAll() { return repo.findAll(); }
    public Patient getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", id));
    }
    public Patient update(Long id, Patient updated) {
        Patient p = getById(id);
        p.setName(updated.getName());
        p.setAge(updated.getAge());
        p.setContactNumber(updated.getContactNumber());
        p.setAddress(updated.getAddress());
        return repo.save(p);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
