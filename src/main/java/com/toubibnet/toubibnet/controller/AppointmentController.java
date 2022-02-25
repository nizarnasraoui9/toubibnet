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
@CrossOrigin("http://localhost:4200")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    AppointmentMapper appointmentMapper;

    @GetMapping("/available/{doctorId}/{day}/{month}/{year}")
    public List<LocalDateTime>getAvailableAppointments(@PathVariable("doctorId") Long doctorId
    ,@PathVariable("day")Integer day,@PathVariable("month")Integer month
            ,@PathVariable("year")Integer year){
        return this.appointmentService.getAvailableAppointments(doctorId,day,month,year);
    }
    @GetMapping("/history/{doctorId}")
    public List<AppointmentDto>getAppointmentsHitory(@PathVariable("doctorId")Long doctorId){
        List<Appointment>appointmentsHistory=this.appointmentService.getAllAppointments(doctorId);
        return this.appointmentMapper.toDtos(appointmentsHistory);
    }
    @PostMapping
    public Appointment addAppointment(@RequestBody AppointmentDto appointment){
        Appointment newAppointment=this.appointmentMapper.toBo(appointment);
        return this.appointmentService.addAppointment(newAppointment);
    }

}
