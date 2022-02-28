package com.toubibnet.toubibnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.toubibnet.toubibnet.exception.UserNotFoundException;
import com.toubibnet.toubibnet.model.Doctor;
import com.toubibnet.toubibnet.repository.DoctorRepo;

@Service
public class DoctorService {
	@Autowired
	DoctorRepo doctorRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<Doctor> findAllDoctors(){
		return this.doctorRepo.findAll();
	}
	public Doctor findDoctorById(Long id) {
		return doctorRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Doctor by id " + id + " was not found"));
	}
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);	}
	
	public Doctor updateDoctor(Doctor doctor) {
		doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
		return doctorRepo.save(doctor);
	}
	
	public void deleteDoctor(Long id){
		doctorRepo.deleteById(id);
    }
}
