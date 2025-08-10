package com.clinicmanagement.Services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clinicmanagement.exception.ResourceNotFoundException;
import com.clinicmanagement.model.Doctor;
import com.clinicmanagement.repository.DoctorRepository;

@Service
public class DoctorService {
    private final DoctorRepository repo;
    public DoctorService(DoctorRepository repo) { this.repo = repo; }

    public Doctor create(Doctor d){ return repo.save(d); }
    public List<Doctor> getAll(){ return repo.findAll(); }
    public Doctor getById(Long id){
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", id));
    }
    public Doctor update(Long id, Doctor updated){
        Doctor d = getById(id);
        d.setName(updated.getName());
        d.setSpecialization(updated.getSpecialization());
        d.setContactNumber(updated.getContactNumber());
        return repo.save(d);
    }
    public void delete(Long id){ repo.deleteById(id); }
}
