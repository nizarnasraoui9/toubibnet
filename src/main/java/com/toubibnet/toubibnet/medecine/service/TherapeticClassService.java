package com.toubibnet.toubibnet.medecine.service;


import com.toubibnet.toubibnet.medecine.entity.MedecineClass;
import com.toubibnet.toubibnet.medecine.entity.TheurapeticClass;
import com.toubibnet.toubibnet.medecine.repository.TheurapeticClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TherapeticClassService {

    @Autowired
    TheurapeticClassRepository theurapeticClassRepository ;


            public void createTherapetic(TheurapeticClass theurapeticClass) {
                theurapeticClassRepository.save(theurapeticClass) ;
            }
            public void deleteTherapetic (Long id) {
            theurapeticClassRepository.deleteById(id);
            }

            public TheurapeticClass updateTherapetic (TheurapeticClass theurapeticClass) {
                TheurapeticClass th ;
                th = theurapeticClassRepository.findById(theurapeticClass.getId()).get() ;
                th = theurapeticClassRepository.save(th) ;
                return th ;
            }

            public TheurapeticClass getTherapeuticById (Long id) {
                return theurapeticClassRepository.findById(id).get() ;
            }

            public TheurapeticClass getTheurapeuticByName (String name) {
            return theurapeticClassRepository.findByName(name);
            }

            public List<TheurapeticClass> getAllTherapetic() {
               /* List<TheurapeticClass> theurapeticClasses ;
                    theurapeticClasses = theurapeticClassRepository.findAll() ;
                for (TheurapeticClass th: theurapeticClasses)
                {
                        List<MedecineClass> medicines ;
                        medicines = th.getMedicines() ;

                    for (MedecineClass med: medicines )
                    {
                            med.setTheurapetic(null);

                    }

                }
                return theurapeticClasses ; */
                return theurapeticClassRepository.findAll() ;
            }
}
