package com.toubibnet.toubibnet;

import com.toubibnet.toubibnet.model.Appointment;
import com.toubibnet.toubibnet.model.Doctor;
import com.toubibnet.toubibnet.model.User;
import com.toubibnet.toubibnet.repository.AppointementRepo;
import com.toubibnet.toubibnet.repository.DoctorRepo;
import com.toubibnet.toubibnet.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ToubibnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToubibnetApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepo userRepo, DoctorRepo doctorRepo
			, AppointementRepo appointementRepo) {
		return args -> {

		};
	}
}
