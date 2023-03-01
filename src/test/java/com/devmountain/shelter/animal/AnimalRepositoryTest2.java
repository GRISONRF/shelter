package com.devmountain.shelter.animal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.devmountain.shelter.health.Health;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AnimalRepositoryTest2 {

    @Autowired
    private AnimalRepository animalRepository;



    @Test
    public void testFindAllWithHealth() {
        // given
        Health health = new Health();
        health.setSpayed("yes");
        health.setStool("normal");
        health.setWeight("30lb");
        health.setAllergy("no");
        health.setDisability("no");
        health.setQuarantine("no");
        health.setMedicalRest("no");

        Animal animal = new Animal();
        animal.setSpecies("Cat");
        animal.setName("Lion");
        animal.setDob("01/03/2016");
        animal.setGender("Male");
        animal.setIntakeDate("02/27/2023");
        animal.setIntakeMethod("Rescued");
        animal.setPicture("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/640px-Cat03.jpg");
        animal.setBreed("Short hair");
        animal.setFood("Purina Cat Chow Complete Dry Cat Food");
        animal.setFood_amount("1 scoop 2x day");
        animal.setAvailability("Available for Adoption");
        animal.setDisposition(null);
        animal.setHealth(health);
        animalRepository.save(animal);


        // when
        List<Animal> animals = animalRepository.findAllWithHealth();

        // then
        assertThat(animals).hasSize(1);
        assertThat(animals.get(0).getHealth()).isNotNull();
    }
}

