package com.toubibnet.toubibnet.medecine.repository;

import com.toubibnet.toubibnet.medecine.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepository extends JpaRepository<Laboratory,Long> {

     Laboratory findByName (String name) ;
}
