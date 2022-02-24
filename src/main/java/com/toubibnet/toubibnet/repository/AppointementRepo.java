package com.toubibnet.toubibnet.repository;

import com.toubibnet.toubibnet.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointementRepo extends JpaRepository<Appointment, Long> {
    List<Appointment>findAllByDoctorId(Long doctorId);
    List<Appointment>findByDoctor_Id(Long doctorId);



}
