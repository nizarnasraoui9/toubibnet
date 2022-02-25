package com.toubibnet.toubibnet.medecine.controller;


import com.toubibnet.toubibnet.medecine.entity.TheurapeticClass;
import com.toubibnet.toubibnet.medecine.service.TherapeticClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/therapeutics")
public class TheurapeticClassController {

    @Autowired
    TherapeticClassService therapeticClassService ;

    @GetMapping("/getAll")
    public List<TheurapeticClass> getAllTherapetic() {
        return therapeticClassService.getAllTherapetic() ;
    }

    @PostMapping("/create")
    public String createMed (@RequestBody TheurapeticClass theurapeticClass) {
        therapeticClassService.createTherapetic(theurapeticClass);
        return "Create success" ;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTherapetic (@PathVariable("id") Long id) {
        therapeticClassService.deleteTherapetic(id) ;
        return("Delete with success") ;
    }

    @PutMapping("/update")
    public TheurapeticClass updateMed (@RequestBody TheurapeticClass theurapeticClass)
    {
        return therapeticClassService.updateTherapetic(theurapeticClass) ;

    }

    @GetMapping("/therapeutic/{id}")
    public TheurapeticClass getTherapeticById (@PathVariable("id") Long id ) {
        return therapeticClassService.getTherapeuticById(id) ;
    }

    @GetMapping("/therap/{name}")
    public TheurapeticClass getTherapeticByName (@PathVariable("name") String name) {
        return therapeticClassService.getTheurapeuticByName(name) ;
    }
}
