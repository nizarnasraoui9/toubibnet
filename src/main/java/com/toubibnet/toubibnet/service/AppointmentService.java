package com.toubibnet.toubibnet.service;

import com.toubibnet.toubibnet.repository.AppointementRepo;
import com.toubibnet.toubibnet.repository.DoctorRepo;
import com.toubibnet.toubibnet.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.toubibnet.toubibnet.model.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AppointmentService {
    @Autowired
    AppointementRepo appointementRepo;
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    UserRepo userRepo;

    public Appointment addAppointment (Appointment appointment){
        Appointment newAppointment =this.appointementRepo.save(appointment);
        return null;
    }
    public List<Appointment>getTakenAppointments(Long doctorId){
        List<Appointment>appointments=this.appointementRepo.findAllByDoctorId(doctorId);
        return appointments;
    }
    public List<LocalDateTime>getAvailableAppointments(Long doctorId){
        List<Appointment>takenAppointments=new ArrayList<>();
        List<LocalDateTime>availableAppointments=new ArrayList<>();
        takenAppointments=this.getTakenAppointments(doctorId);
        Integer hour=8;
        while(hour<18){
            availableAppointments.add(LocalDate.now().atTime(hour,0));
            availableAppointments.add(LocalDate.now().atTime(hour,30));
            hour++;
        }
        takenAppointments.forEach((appointment -> {
            LocalDateTime date=appointment.getDate();
            if(availableAppointments.contains(date)){
                availableAppointments.remove(date);
            }
        }));


        return availableAppointments;
    }

    public List<Appointment> getAllAppointments(Long doctorId) {
        return this.appointementRepo.findAllByDoctorId(doctorId);
    }
}