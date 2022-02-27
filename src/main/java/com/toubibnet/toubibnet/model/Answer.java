package com.toubibnet.toubibnet.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    @ManyToOne
    @JoinColumn(name="question_id",referencedColumnName = "id")
    Question question;
    @ManyToOne
    @JoinColumn(name="doctor_id",referencedColumnName = "id")
    Doctor doctor;
    Date date;
}