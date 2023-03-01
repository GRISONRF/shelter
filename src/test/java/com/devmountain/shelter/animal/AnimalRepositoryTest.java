package com.devmountain.shelter.animal;

import com.devmountain.shelter.health.Health;
import com.devmountain.shelter.health.HealthRepository;
import com.devmountain.shelter.task.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

@DataJpaTest
class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository underTest;
    @Autowired
    private HealthRepository healthRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Test
    void itShouldFindAllAnimalsWithHealth() {

        //given
        Health health = new Health(null,
                "spayed YES",
                "stool NORMAL",
                "3lb",
                "No allergy",
                "no disability",
                "no",
                "no",
                null);
        healthRepository.save(health);

        Animal animal = new Animal(null,
                "Cat",
                "Fluffy",
                "10/04/2020",
                "Female",
                "01/01/2023",
                "Rescued",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/640px-Cat03.jpg",
                "Unknown",
                "Pedigree Cat Food",
                "1 scoop 2x day",
                "Available for Adoption",
                null, health);
        underTest.save(animal);

        EmailSenderService emailSenderService = mock(EmailSenderService.class);

        //when
        List<Animal> expected =  underTest.findAllWithHealth();

        //then
        assertThat(expected).isNotNull();
    }
}