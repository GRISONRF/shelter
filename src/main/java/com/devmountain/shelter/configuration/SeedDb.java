package com.devmountain.shelter.configuration;

import com.devmountain.shelter.animal.Animal;
import com.devmountain.shelter.animal.AnimalRepository;
import com.devmountain.shelter.disposition.DispositionRepository;
import com.devmountain.shelter.health.HealthRepository;
import com.devmountain.shelter.staff.Staff;
import com.devmountain.shelter.staff.StaffRepository;
import com.devmountain.shelter.task.Task;
import com.devmountain.shelter.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = {"com.devmountain.shelter.staff"})
@ComponentScan(basePackages = {"com.devmountain.shelter.animal"})
//@Profile("Test")
public class SeedDb implements CommandLineRunner {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private HealthRepository healthRepository;
    @Autowired
    private DispositionRepository dispositionRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private TaskRepository taskRepository;


    @Override
    public void run(String ... args) throws Exception {

        Animal animal1 = new Animal(null, "Cat", "Fluffy", "10/04/2020", "Female", "Available for Adoption");
        Animal animal2 = new Animal(null, "Dog", "Kai", "06/01/2019", "Male", "Available for Foster");
        Animal animal3 = new Animal(null, "Dog", "Fluffy", "10/04/2020", "Female", "Available for Adoption");
        Animal animal4 = new Animal(null, "Cat", "Fluffy", "10/04/2020", "Female", "Fostered");
        Animal animal5 = new Animal(null, "Dog", "Fluffy", "10/04/2020", "Female", "Shelter Care");
        animalRepository.saveAll(Arrays.asList(animal1, animal2, animal3, animal4, animal5));


        Staff staff1 = new Staff();
        staff1.setId(null);
        staff1.setEmail("staff1@test.com");
        staff1.setPassword("123test");
        staff1.setName("Amanda Jones");
        staff1.setPhone("(720) 232-0909");
        staff1.setAddress("Denver-CO");
        staff1.setRole("Volunteer");
        staffRepository.saveAll(Arrays.asList(staff1));

//        Animal animalTest = animalRepository.findById(1L).orElse(null);
//        Staff staffTest = staffRepository.findById(1L).orElse(null);
//        Task task1 = new Task(null, "Take the trash out", "Wednesday - 2pm", animal1, staff1);
//        taskRepository.saveAll(Arrays.asList(task1));

    }
}
