package com.toubibnet.toubibnet.repository;

import com.toubibnet.toubibnet.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointementRepo extends JpaRepository<Appointment, Long> {
}
