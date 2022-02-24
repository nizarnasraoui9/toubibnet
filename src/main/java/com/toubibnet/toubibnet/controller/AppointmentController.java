package com.toubibnet.toubibnet.controller;

import com.toubibnet.toubibnet.model.Appointment;
import com.toubibnet.toubibnet.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @GetMapping("/available/{doctorId}")
    public List<LocalDateTime>getAvailableAppointments(@PathVariable("doctorId") Long doctorId){
        return this.appointmentService.getAvailableAppointments(doctorId);
    }
    @GetMapping("/history{doctorId}")
    public List<Appointment>getAppointmentsHitory(@PathVariable("doctorid")Long doctorId){
        return this.appointmentService.getAllAppointments(doctorId);
    }
    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment){
        return this.appointmentService.addAppointment(appointment);
    }

}
