package com.toubibnet.toubibnet.medecine.repository;

import com.toubibnet.toubibnet.medecine.entity.MedecineClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecineRepository extends JpaRepository<MedecineClass,Long> {

}
