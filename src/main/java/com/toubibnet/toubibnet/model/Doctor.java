package com.toubibnet.toubibnet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor extends User{
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
    @Enumerated(EnumType.STRING)
    Speciality speciality;
    @Enumerated(EnumType.STRING)
    Governorate governotate;
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Appointment> appointmentList=new ArrayList<>();
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Article>articles=new ArrayList<>();
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Answer>answers=new ArrayList<>();


}
