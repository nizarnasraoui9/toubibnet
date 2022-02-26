package com.toubibnet.toubibnet.repository;

import com.toubibnet.toubibnet.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointementRepo extends JpaRepository<Appointment, Long> {
    List<Appointment>findAllByDoctorIdOrderByDateDesc(Long doctorId);
    List<Appointment>findByDoctor_Id(Long doctorId);
    @Query(value = "select * from appointment where date >= now() and doctor_id=:doctorId order by date desc ;",nativeQuery = true)
    List<Appointment>getAppointmentsByDoctorId(@Param("doctorId") Long doctorId);




}
