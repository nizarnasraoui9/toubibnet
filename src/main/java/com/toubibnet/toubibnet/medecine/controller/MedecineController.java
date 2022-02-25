package com.toubibnet.toubibnet.medecine.controller;


import com.toubibnet.toubibnet.medecine.entity.MedecineClass;
import com.toubibnet.toubibnet.medecine.service.MedecineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/ApiMed")
public class MedecineController {

    @Autowired
    MedecineService medecineService ;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    public List<MedecineClass> getAllMedecine() {
        return medecineService.getAllMed() ;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public MedecineClass createMed (@RequestBody MedecineClass medecin) {
        System.out.println("ceci post medicine");
        medecineService.createMedecine(medecin);
        System.out.println("ajout dans base success");
        return medecin ;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public String deleteMed (@PathVariable("id") Long id) {
        medecineService.deleteMedecine(id) ;
        return("Delete with success") ;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public MedecineClass updateMed (@RequestBody MedecineClass med)
    {
         return medecineService.updateMedecine(med) ;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/medicine/{id}")
    public MedecineClass getMedecine (@PathVariable("id") Long id ) {
        return medecineService.getMedecineById(id) ;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/med/{name}")
    public MedecineClass getMedecineByName (@PathVariable("name") String name) {
        return medecineService.getMedecineByName(name) ;
    }
}
