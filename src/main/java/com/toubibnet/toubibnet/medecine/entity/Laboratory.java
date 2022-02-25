package com.toubibnet.toubibnet.medecine.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "laboratory")
public class Laboratory {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;

    @Column(name = "name")
    private String name ;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "laboratory")
    private List<MedecineClass> medicines ;

    public Laboratory(Long id, String name, List<MedecineClass> medicines) {
        this.id = id;
        this.name = name;
        this.medicines = medicines ;
    }

    public void setMedicines(List<MedecineClass> medicines) {
        this.medicines = medicines;
    }

    public List<MedecineClass> getMedicines() {
        return medicines;
    }

    public Laboratory () {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
