package com.toubibnet.toubibnet.medecine.controller;


import com.toubibnet.toubibnet.medecine.entity.Laboratory;
import com.toubibnet.toubibnet.medecine.entity.MedecineClass;
import com.toubibnet.toubibnet.medecine.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/laboratories")
@CrossOrigin(origins = "http://localhost:4200")
public class LaboratoryController {

    @Autowired
    LaboratoryService laboratoryService ;

    @GetMapping("/getAll")
    public List<Laboratory> getAllLaboratories() {
        return laboratoryService.getAllLabo() ;
    }

    @PostMapping("/create")
    public String createLaboratory (@RequestBody Laboratory laboratory) {
        laboratoryService.createLaboratory(laboratory);
        return "Create success" ;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLaboratory (@PathVariable("id") Long id) {
        laboratoryService.deleteLaboratory(id) ;
        return("Delete with success") ;
    }

    @PutMapping("/update")
    public Laboratory updateLaboratory (@RequestBody Laboratory laboratory)
    {
        return laboratoryService.updateLaboratory(laboratory) ;

    }

    @GetMapping("/laboratory/{id}")
    public Laboratory getLaboratoryById (@PathVariable("id") Long id ) {
        return laboratoryService.getLaboratoryById(id) ;
    }

    @GetMapping("/labo/{name}")
    public Laboratory getLaboratoryByName (@PathVariable("name") String name) {
        return laboratoryService.getLaboratoryByName(name) ;
    }


}
