package com.toubibnet.toubibnet.controller;

import com.toubibnet.toubibnet.dto.AppointmentDto;
import com.toubibnet.toubibnet.mapper.AppointmentMapper;
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
    @Autowired
    AppointmentMapper appointmentMapper;

    @GetMapping("/available/{doctorId}")
    public List<LocalDateTime>getAvailableAppointments(@PathVariable("doctorId") Long doctorId){
        return this.appointmentService.getAvailableAppointments(doctorId);
    }
    @GetMapping("/history/{doctorId}")
    public List<AppointmentDto>getAppointmentsHitory(@PathVariable("doctorId")Long doctorId){
        List<Appointment>appointmentsHistory=this.appointmentService.getAllAppointments(doctorId);
        return this.appointmentMapper.toDtos(appointmentsHistory);
    }
    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment){
        return this.appointmentService.addAppointment(appointment);
    }

}
