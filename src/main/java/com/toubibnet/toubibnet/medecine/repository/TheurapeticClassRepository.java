package com.toubibnet.toubibnet.medecine.repository;

import com.toubibnet.toubibnet.medecine.entity.TheurapeticClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheurapeticClassRepository extends JpaRepository<TheurapeticClass,Long> {
    TheurapeticClass findByName ( String name) ;

    }
