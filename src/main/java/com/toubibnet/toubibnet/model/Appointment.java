package com.toubibnet.toubibnet.model;

public class Appointment {
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date date;
    @ManyToOne
    @JoinColumn(name="doctor_id",referencedColumnName = "id")
    Doctor doctor;
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    User user;


}
