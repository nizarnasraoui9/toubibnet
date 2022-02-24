package com.toubibnet.toubibnet.medecine.service;

import com.toubibnet.toubibnet.medecine.entity.MedecineClass;
import com.toubibnet.toubibnet.medecine.repository.MedecineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecineService {

    @Autowired
    MedecineRepository medecineRepository ;

    public List<MedecineClass> getAllMed () {
        return medecineRepository.findAll() ;
    }
}
