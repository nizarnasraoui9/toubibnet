package com.toubibnet.toubibnet.medecine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "medecineTable")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedecineClass {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id ;

        @Column(name = "name")
        private String name;

        @Column(name = "description")
        private String description ;




}
