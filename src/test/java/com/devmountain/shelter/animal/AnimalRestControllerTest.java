package com.devmountain.shelter.animal;

import com.devmountain.shelter.TestConfigForMail;
import com.devmountain.shelter.disposition.Disposition;
import com.devmountain.shelter.disposition.DispositionDto;
import com.devmountain.shelter.disposition.DispositionRepository;
import com.devmountain.shelter.health.HealthRepository;
import com.devmountain.shelter.notes.NoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(AnimalRestController.class)
@AutoConfigureMockMvc
//@Import(TestConfigForMail.class)
public class AnimalRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AnimalRepository animalRepository;

    @MockBean
    private AnimalService animalService;

//    @MockBean
//    private DispositionRepository dispositionRepository;
//
//    @MockBean
//    private HealthRepository healthRepository;
//
//    @MockBean
//    private NoteRepository noteRepository;

    /* check if the endpoint /add-animal successfully creates a new animal*/
    @Test
    void testAddAnimal() throws Exception {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setSpecies("Cat");
        animalDto.setName("Lion");
        animalDto.setDob("01/03/2016");
        animalDto.setGender("Male");
        animalDto.setIntakeDate("02/27/2023");
        animalDto.setIntakeMethod("Rescued");
        animalDto.setPicture("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/640px-Cat03.jpg");
        animalDto.setBreed("Short hair");
        animalDto.setFood("Purina Cat Chow Complete Dry Cat Food");
        animalDto.setFood_amount("1 scoop 2x day");
        animalDto.setAvailability("Available for Adoption");
        animalDto.setDisposition(null);
        animalDto.setHealth(null);

        mockMvc.perform(post("/api/animal/add-animal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(animalDto)))
                .andExpect(status().isOk());
//                .andExpect(content().string("Animal Added Successfully"));

    }

    /*Test is animal is saved in the database */
    @Test
    void testAnimalSavedInDatabase() throws Exception {

        //create animal in the database
        AnimalDto animalDto = new AnimalDto();
        animalDto.setSpecies("Cat");
        animalDto.setName("Lion");
        animalDto.setDob("01/03/2016");
        animalDto.setGender("Male");
        animalDto.setIntakeDate("02/27/2023");
        animalDto.setIntakeMethod("Rescued");
        animalDto.setPicture("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/640px-Cat03.jpg");
        animalDto.setBreed("Short hair");
        animalDto.setFood("Purina Cat Chow Complete Dry Cat Food");
        animalDto.setFood_amount("1 scoop 2x day");
        animalDto.setAvailability("Available for Adoption");
        animalDto.setDisposition(null);
        animalDto.setHealth(null);

        Animal animal = new Animal();
        animal.setSpecies(animalDto.getSpecies());
        animal.setName(animalDto.getName());
        animal.setDob(animalDto.getDob());
        animal.setGender(animalDto.getGender());
        animal.setIntakeDate(animalDto.getIntakeDate());
        animal.setIntakeMethod(animalDto.getIntakeMethod());
        animal.setPicture(animalDto.getPicture());
        animal.setBreed(animalDto.getBreed());
        animal.setFood(animalDto.getFood());
        animal.setFood_amount(animalDto.getFood_amount());
        animal.setAvailability(animalDto.getAvailability());
        animal.setDisposition(null);
        animal.setHealth(null);

        animalRepository.save(animal);

        //send a POST request to the add-animal endpoint with the sample AnimalDto object
        mockMvc.perform(post("/api/animal/add-animal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(animal)))
                .andExpect(status().isOk());
//                .andExpect(content().string("Animal Added Successfully"));

        //retrieve all animals from the database and assert that the values match the AnimalDto object
        List<Animal> animals = animalRepository.findAll();
         assertThat(animals).hasSize(1);
        assertThat(animals.get(0).getName()).isEqualTo("Lion");
        assertThat(animals.get(0).getSpecies()).isEqualTo("Cat");
        assertThat(animals.get(0).getDob()).isEqualTo("01/03/2016");
        assertThat(animals.get(0).getGender()).isEqualTo("Male");
        assertThat(animals.get(0).getIntakeMethod()).isEqualTo("Rescued");
        assertThat(animals.get(0).getBreed()).isEqualTo("Short hair");
        assertThat(animals.get(0).getAvailability()).isEqualTo("Available for Adoption");

    }
        /*Test if disposition entity is saved in the database*/
        @Test
        void testDispositionSavedInDatabase() throws Exception {
            AnimalDto animalDto = new AnimalDto();
            animalDto.setSpecies("Cat");
            animalDto.setName("Lion");
            animalDto.setDob("01/03/2016");
            animalDto.setGender("Male");
            animalDto.setIntakeDate("02/27/2023");
            animalDto.setIntakeMethod("Rescued");
            animalDto.setPicture("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/640px-Cat03.jpg");
            animalDto.setBreed("Short hair");
            animalDto.setFood("Purina Cat Chow Complete Dry Cat Food");
            animalDto.setFood_amount("1 scoop 2x day");
            animalDto.setAvailability("Available for Adoption");
            animalDto.setDisposition(null);
            animalDto.setHealth(null);

            DispositionDto dispositionDto = new DispositionDto();
            dispositionDto.setPotty("Yes");
            dispositionDto.setLeash("Reactive");
            dispositionDto.setKids("Good");
            dispositionDto.setOtherAnimals("Does not like dogs");
            dispositionDto.setTemper("Friendly");
            dispositionDto.setCrate("No");
            dispositionDto.setComments("Good cat");
            animalDto.setDisposition(dispositionDto);


            mockMvc.perform(post("/add-animal")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(animalDto)))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Animal Added Successfully"));

//            List<Disposition> dispositions = dispositionRepository.findAll();
//            assertThat(dispositions.size()).isEqualTo(1);
//            assertThat(dispositions.get(0).getPotty()).isEqualTo("Yes");
//            assertThat(dispositions.get(0).getLeash()).isEqualTo("Reactive");
//            assertThat(dispositions.get(0).getKids()).isEqualTo("Good");
//            assertThat(dispositions.get(0).getComments()).isEqualTo("Good cat");


        }
}
