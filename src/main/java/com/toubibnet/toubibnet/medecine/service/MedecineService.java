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

    public void createMedecine  (MedecineClass med) {
        medecineRepository.save(med) ;
    }

    public void deleteMedecine(Long id) {
        medecineRepository.deleteById(id);
    }

    public MedecineClass updateMedecine(MedecineClass med) {
        MedecineClass medecine ;
        medecine = medecineRepository.findById(med.getId()).get() ;
        medecine = medecineRepository.save(medecine) ;
        return medecine ;
    }


    public MedecineClass getMedecineById (Long id) {
        return medecineRepository.findById(id).get() ;
    }

    public MedecineClass getMedecineByName ( String name) {
        return medecineRepository.findByName(name) ;
    }



}
