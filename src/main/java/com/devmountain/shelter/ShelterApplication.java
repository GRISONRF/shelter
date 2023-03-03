package com.devmountain.shelter;

import com.devmountain.shelter.animal.Animal;
import com.devmountain.shelter.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
//@ComponentScan(basePackages = "com.devmountain.shelter")
public class ShelterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShelterApplication.class, args);
	}


}
