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

    @GetMapping("/getAll")
    public List<MedecineClass> getAllMedecine() {
        return medecineService.getAllMed() ;
    }

    @PostMapping("/create")
    public String createMed (@RequestBody MedecineClass medecin) {
        medecineService.createMedecine(medecin);
        return "Create success" ;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMed (@PathVariable("id") Long id) {
        medecineService.deleteMedecine(id) ;
        return("Delete with success") ;
    }

    @PutMapping("/update")
    public MedecineClass updateMed (@RequestBody MedecineClass med)
    {
         return medecineService.updateMedecine(med) ;

    }

    @GetMapping("/medecine/{id}")
    public MedecineClass getMedecine (@PathVariable("id") Long id ) {
        return medecineService.getMedecineById(id) ;
    }

    @GetMapping("/med/{name}")
    public MedecineClass getMedecineByName (@PathVariable("name") String name) {
        return medecineService.getMedecineByName(name) ;
    }
}
