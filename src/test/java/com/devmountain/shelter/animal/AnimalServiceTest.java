package com.devmountain.shelter.animal;

import com.devmountain.shelter.animal.Animal;
import com.devmountain.shelter.animal.AnimalDto;
import com.devmountain.shelter.animal.AnimalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AnimalServiceTest {

    @Autowired
    private AnimalService animalService;

//    @Test
//    public void testGetAllAnimals() {
//        List<AnimalDto> animals = animalService.findAllAnimals();
//        assertThat(animals).isNotEmpty();
//    }

//    @Test
//    public void testGetAnimalById() {
//        Animal animal = animalService.getAnimalById(1L);
//        assertThat(animal).isNotNull();
//        assertThat(animal.getId()).isEqualTo(1L);
//    }


    /*
    * @Test
public void testAddMultipleAnimals() {
    AnimalDto animal1 = new AnimalDto();
    animal1.setName("Animal 1");
    animal1.setSpecies("Species 1");
    animal1.setDob("01/01/2022");
    animal1.setGender("Male");
    animal1.setAvailability("Available for Adoption");
    animalService.addAnimal(animal1);

    AnimalDto animal2 = new AnimalDto();
    animal2.setName("Animal 2");
    animal2.setSpecies("Species 2");
    animal2.setDob("01/01/2022");
    animal2.setGender("Male");
    animal2.setAvailability("Available for Adoption");
    animalService.addAnimal(animal2);

    // ...add more animals

    List<Animal> savedAnimals = animalRepository.findAll();
    assertThat(savedAnimals).hasSize(10);
}
}*/




}
