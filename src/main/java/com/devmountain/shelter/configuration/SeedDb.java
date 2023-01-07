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

        Animal animal1 = new Animal(null, "Cat", "Fluffy", "10/04/2020", "Female", "01/01/2023", "Rescued", "Unknown", "Pedigree Cat Food", "1 scoop 2x day", "Available for Adoption");
        Animal animal2 = new Animal(null, "Dog", "Kai", "06/01/2019", "Male", "06/01/2019", "Born in shelter", "Golden Retriever", "Dog food brand name", "2 1/2 scoops 2x day", "Available for Foster");
        Animal animal3 = new Animal(null, "Dog", "Fluffy", "01/14/2021", "Female", "07/25/2021", "Stray Animal", "Poodle", "Doog food", "1 scoop 2x day", "Available for Adoption");
        Animal animal4 = new Animal(null, "Cat", "Luna", "08/30/2022", "Female", "11/28/2022", "Transderred", "Siamese", "Cat food", "1/2 scoop 2x day", "Fostered");
        Animal animal5 = new Animal(null, "Dog", "Bella", "05/18/2018", "Female", "09/12/2019", "Surrender", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care");
        animalRepository.saveAll(Arrays.asList(animal1, animal2, animal3, animal4, animal5));


        Staff staff1 = new Staff();
        staff1.setId(null);
        staff1.setEmail("staff1@test.com");
        staff1.setPassword("123test");
        staff1.setName("Amanda Jones");
        staff1.setPhone("(720) 232-0909");
        staff1.setAddress("Denver-CO");
        staff1.setRole("Volunteer");

        Staff staff2 = new Staff();
        staff2.setName("Sandra Olmo");
        staff2.setPassword("123test");
        staff2.setEmail("staff2@test.com");
        staff1.setPhone("(720) 111-5050");
        staff1.setRole("Manager");

        Staff staff3 = new Staff();
        staff3.setName("Patrick Callahan");
        staff3.setPassword("123test");
        staff3.setEmail("staff3@test.com");
        staff1.setPhone("(360) 455-9977");
        staff1.setRole("Animal caretaker");

        Staff staff4 = new Staff();
        staff4.setName("Gloria Phipps");
        staff4.setPassword("123test");
        staff4.setEmail("staff4@test.com");
        staff1.setPhone("(240) 324-1133");
        staff1.setRole("Veterinarian");

        Staff staff5 = new Staff();
        staff5.setName("Dennis Johnson");
        staff5.setPassword("123test");
        staff5.setEmail("staff5@test.com");
        staff1.setPhone("(240) 689-4022");
        staff1.setRole("Kennel technician");
        staffRepository.saveAll(Arrays.asList(staff1,staff2, staff3, staff4, staff5));




        Animal animalTest = animalRepository.findById(1L).orElse(null);
        Staff staffTest = staffRepository.findById(1L).orElse(null);
        Task task1 = new Task(null, "Take the trash out", "Wednesday - 2pm", staff1);
        Task task2 = new Task(null, "Feed the cats", "Monday - 7am and 6pm", staff2);
        Task task3 = new Task(null, "Take Fluffy to get the vaccines", "Tuesday 1pm", staff4);
        Task task4 = new Task(null, "Clean the kennel", "Friday", staff3);
        Task task5 = new Task(null, "Feed the dogs", "Tuesday - 10am", staff1);
        taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4, task5));



    }
}
