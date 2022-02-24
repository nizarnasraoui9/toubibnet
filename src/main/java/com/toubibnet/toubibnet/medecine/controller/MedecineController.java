package com.toubibnet.toubibnet.medecine.controller;


import com.toubibnet.toubibnet.medecine.entity.MedecineClass;
import com.toubibnet.toubibnet.medecine.service.MedecineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
