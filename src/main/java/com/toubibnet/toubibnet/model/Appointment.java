package com.toubibnet.toubibnet.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime date;
    @ManyToOne
    @JoinColumn(name="doctor_id",referencedColumnName = "id")
    Doctor doctor;
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    User user;

    public Appointment(Long id, LocalDateTime date, Doctor doctor, User user) {
        this.id = id;
        this.date = date;
        this.doctor = doctor;
        this.user = user;
    }
}
