package com.toubibnet.toubibnet.dto;

import com.toubibnet.toubibnet.model.Doctor;
import com.toubibnet.toubibnet.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;

public class AppointmentDto {
    Long id;
    LocalDateTime date;
    Doctor doctor;
    User user;
}
