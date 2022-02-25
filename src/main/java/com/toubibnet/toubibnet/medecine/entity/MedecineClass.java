package com.toubibnet.toubibnet.medecine.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "medecine_table")
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

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "laboratory_id")
        private Laboratory laboratory ;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "therapeutic_id")
        private TheurapeticClass theurapetic ;


        public MedecineClass(Long id, String name, String description) {

                this.id = id;
                this.name = name;
                this.description = description;
        }

        public MedecineClass() {

        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getDescription() {
                return description;
        }

        public Laboratory getLaboratory() {
                return laboratory;
        }

        public void setLaboratory(Laboratory laboratory) {
                this.laboratory = laboratory;
        }

        public TheurapeticClass getTheurapetic() {
                return theurapetic;
        }

        public void setTheurapetic(TheurapeticClass theurapetic) {
                this.theurapetic = theurapetic;
        }
}
