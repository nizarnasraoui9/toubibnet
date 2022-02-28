package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.exception.ResourceNotFoundException;
import com.toubibnet.toubibnet.repository.AppointementRepo;
import com.toubibnet.toubibnet.repository.DoctorRepo;
import com.toubibnet.toubibnet.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.toubibnet.toubibnet.model.Appointment;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class AppointmentService {
    @Autowired
    AppointementRepo appointementRepo;
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    UserRepo userRepo;

    public Appointment addAppointment (@Validated Appointment appointment) throws ResourceNotFoundException {
        Long userId=appointment.getUser().getId();
        Long doctorId=appointment.getDoctor().getId();
        this.checkDoctor(doctorId);
        this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not provided"));
        Appointment newAppointment =this.appointementRepo.save(appointment);
        log.info("new appointment added");
        return newAppointment;
    }
    public List<Appointment>getTakenAppointments(Long doctorId) throws ResourceNotFoundException {
        this.checkDoctor(doctorId);
        List<Appointment>appointments=this.appointementRepo.getFutureAppointmentsByDoctorId(doctorId);
        log.info("taken appointments: "+appointments);
        return appointments;
    }
    public List<LocalDateTime>getAvailableAppointments(Long doctorId,Integer day,Integer month,Integer year) throws ResourceNotFoundException {
        List<Appointment>takenAppointments;
        List<LocalDateTime>availableAppointments=new ArrayList<>();
        takenAppointments=this.getTakenAppointments(doctorId);
        int hour=8;
        while(hour<18){
            if(hour!=12 && hour!=13){
                availableAppointments.add(LocalDate.of(year,month,day).atTime(hour,0));
                availableAppointments.add(LocalDate.of(year,month,day).atTime(hour,30));

            }

            hour++;
        }
        takenAppointments.forEach((appointment -> {
            LocalDateTime date=appointment.getDate();
            availableAppointments.remove(date);
        }));
        log.info("available appointments: "+availableAppointments);
        return availableAppointments;
    }


    public List<Appointment> getAllFutureAppointments(Long doctorId) throws ResourceNotFoundException {
        this.checkDoctor(doctorId);
        List<Appointment>appointments=this.appointementRepo.getFutureAppointmentsByDoctorId(doctorId);
        log.info("taken appointments: "+appointments);
        return this.appointementRepo.getFutureAppointmentsByDoctorId(doctorId);
    }
    public List<Appointment> getAllAppointmentsHistory(Long doctorId) throws ResourceNotFoundException {
        this.checkDoctor(doctorId);
        List<Appointment>appointments=this.appointementRepo.findAllByDoctorIdOrderByDateDesc(doctorId);
        log.info("appointments history: "+appointments);
        return this.appointementRepo.findAllByDoctorIdOrderByDateDesc(doctorId);
    }
    public void checkDoctor(Long doctorId) throws ResourceNotFoundException {
        this.userRepo.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("user not provided"));
    }


}
