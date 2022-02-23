package com.toubibnet.toubibnet.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Appointment {
    @EmbeddedId
    AppointmentId appointmentId;
    Date date;
    @ManyToOne
    @MapsId("doctorId")
    Doctor doctor;
    @ManyToOne
    @MapsId("userId")
    User user;
}
