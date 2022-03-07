package com.toubibnet.toubibnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.LocalDateTime;
@EnableJpaAuditing
@SpringBootApplication
public class ToubibnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToubibnetApplication.class, args);
	}
}
