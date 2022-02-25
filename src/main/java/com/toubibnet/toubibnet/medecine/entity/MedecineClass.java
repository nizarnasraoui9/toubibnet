package com.toubibnet.toubibnet.medecine.entity;

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


        @ManyToOne
        @JoinColumn(name = "laboratory_id")
        private Laboratory laboratory ;

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
}
