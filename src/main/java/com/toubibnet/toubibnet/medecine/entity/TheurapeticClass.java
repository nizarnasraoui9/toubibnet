package com.toubibnet.toubibnet.medecine.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "therapeutic_class")
public class TheurapeticClass {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @Column (name = "name")
    private String name ;

    @OneToMany(mappedBy = "theurapetic")
    private List<MedecineClass> medicines ;

    public TheurapeticClass () {

    }

    public TheurapeticClass(Long id, String name, List<MedecineClass> medicines) {
        this.id = id;
        this.name = name;
        this.medicines = medicines;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMedicines(List<MedecineClass> medicines_th) {
        this.medicines = medicines_th;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MedecineClass> getMedicines() {
        return medicines;
    }
}
