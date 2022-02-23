package com.toubibnet.toubibnet.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    Speciality speciality;
    @Enumerated(EnumType.STRING)
    Governotate governotate;
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    List<Appointment> appointmentList=new ArrayList<>();
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    List<Article>articles=new ArrayList<>();
}
