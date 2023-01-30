package com.example.RentACar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan({"com.example.RentACar"})
@EntityScan("com.example.RentACar.entity")
@EnableJpaRepositories("com.example.RentACar.repository")
public class RentACarApplication extends SpringBootServletInitializer implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

	}
}
