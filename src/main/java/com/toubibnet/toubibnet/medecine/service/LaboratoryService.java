package com.toubibnet.toubibnet.medecine.service;


import com.toubibnet.toubibnet.medecine.entity.Laboratory;
import com.toubibnet.toubibnet.medecine.entity.MedecineClass;
import com.toubibnet.toubibnet.medecine.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryService {

    @Autowired
    LaboratoryRepository laboratoryRepository ;

    public List<Laboratory> getAllLabo() {
        List<Laboratory> listlab ;
         listlab = laboratoryRepository.findAll() ;
         for (Laboratory lab : listlab) {
             List<MedecineClass> listmed ;
                listmed =  lab.getMedicines() ;
                    for (MedecineClass med : listmed) {
                        med.setLaboratory(null);
                    }
         }
        return listlab ;
    }

    public void createLaboratory(Laboratory laboratory) {
        laboratoryRepository.save(laboratory);
    }

    public void deleteLaboratory (Long id) {
        laboratoryRepository.deleteById(id);
    }
    public Laboratory getLaboratoryById (Long id) {
        return laboratoryRepository.findById(id).get() ;
    }

    public Laboratory getLaboratoryByName ( String name) {
        return laboratoryRepository.findByName(name) ;
    }

    public Laboratory updateLaboratory (Laboratory laboratory) {
        Laboratory lab ;
        lab = laboratoryRepository.findById(laboratory.getId()).get() ;
        lab = laboratoryRepository.save(lab) ;
        return lab ;
    }



}
