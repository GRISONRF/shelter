package com.devmountain.shelter.configuration;

import com.devmountain.shelter.animal.Animal;
import com.devmountain.shelter.animal.AnimalRepository;
import com.devmountain.shelter.disposition.Disposition;
import com.devmountain.shelter.disposition.DispositionRepository;
import com.devmountain.shelter.health.Health;
import com.devmountain.shelter.health.HealthRepository;
import com.devmountain.shelter.notes.Note;
import com.devmountain.shelter.notes.NoteRepository;
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
@ComponentScan(basePackages = {"com.devmountain.shelter.staff", "com.devmountain.shelter.animal"})

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
    @Autowired
    private NoteRepository noteRepository;


    @Override
    public void run(String ... args) throws Exception {


        //TRY TO SEED THE DB WITH DISPOSITION
        Disposition disposition1 = new Disposition(null, "Potty", "leash", "Good with kids", "Good with other animals", "Good temper", "Good in crate", "No comments", null);
        dispositionRepository.save(disposition1);

        Health health1 = new Health(null, "spayed YES", "stool NORMAL", "3lb", "No allergy", "no disability", "no", "no", null );
        healthRepository.save(health1);

        Animal animal1 = new Animal(null, "Cat", "Fluffy", "10/04/2020", "Female", "01/01/2023", "Rescued", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/640px-Cat03.jpg", "Unknown", "Pedigree Cat Food", "1 scoop 2x day", "Available for Adoption", null, null);


        animal1.setDisposition(disposition1);
        animalRepository.save(animal1);
        animal1.setHealth(health1);
        animalRepository.save(animal1);



        Animal animal2 = new Animal(null, "Dog", "Kai", "06/01/2019", "Male", "06/01/2019", "Born in shelter", "https://www.rd.com/wp-content/uploads/2022/01/GettyImages-912084898-e1641834261695.jpg?resize=700,466", "Golden Retriever", "Dog food brand name", "2 1/2 scoops 2x day", "Available for Foster", null, null);
        animal2.setDisposition(disposition1);
        animalRepository.save(animal2);

        Animal animal3 = new Animal(null, "Dog", "Lily", "01/14/2021", "Female", "07/25/2021", "Stray Animal", "https://www.pawtracks.com/wp-content/uploads/sites/2/2022/02/brown-poodle-sitting-by-window.jpg?fit=1024%2C1024&p=1", "Poodle", "Doog food", "1 scoop 2x day", "Available for Adoption", null, null);
        animal3.setDisposition(disposition1);
        animalRepository.save(animal3);

        Animal animal4 = new Animal(null, "Cat", "Luna", "08/30/2022", "Female", "11/28/2022", "Transferred", "https://images.squarespace-cdn.com/content/v1/5e389e57a5944945a0f92994/1581900690817-EHSYM5H567FAOS20GZJ2/shutterstock_143254729.jpg?format=500w", "Siamese", "Cat food", "1/2 scoop 2x day", "Fostered", null, null);
        animal4.setDisposition(disposition1);
        animalRepository.save(animal1);

        Animal animal5 = new Animal(null, "Dog", "Coco Bark Park", "05/18/2018", "Female", "09/12/2019", "Surrender", "https://ggsc.s3.amazonaws.com/images/made/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner_300_200_int_c1-1x.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal5.setDisposition(disposition1);
        animalRepository.save(animal5);

        Animal animal6 = new Animal(null, "Dog", "Stuart", "11/20/2020", "Female", "09/12/2019", "Surrender", "https://www.cdc.gov/healthypets/images/pets/cute-dog-headshot.jpg?_=42445", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal6.setDisposition(disposition1);
        animalRepository.save(animal6);

        Animal animal7 = new Animal(null, "Dog", "Jersey", "03/25/2019", "Female", "09/12/2019", "Surrender", "https://people.com/thmb/yubadLTVOD2kV9iykZ7G68emU4Y=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():focal(904x0:906x2):format(webp)/pug-1-0d4c0f988e3d421ca4954917b1450664.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Available for Adoption", null, null);
        animal7.setDisposition(disposition1);
        animalRepository.save(animal7);

        Animal animal8 = new Animal(null, "Dog", "Shadow", "05/18/2018", "Female", "09/12/2019", "Transferred", "https://www.adelaide.edu.au/newsroom/sites/default/files/styles/ua_image_landscape/public/media/images/2022-03/dog-gbfe9c6841_1920_2.jpg?h=7187ef5e&itok=VvBjqE9_", "Rottweiler", "Dog food", "2 scoops 2x day", "Fostered", null, null);
        animal5.setDisposition(disposition1);
        animalRepository.save(animal8);

        Animal animal9 = new Animal(null, "Dog", "Flower", "01/09/2016", "Female", "09/12/2019", "Stray Animal", "https://puccicafe.com/wp-content/uploads/2021/08/Train-a-Stray-Dog-PUCCI-Cafe.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Fostered", null, null);
        animal9.setDisposition(disposition1);
        animalRepository.save(animal9);

        Animal animal10 = new Animal(null, "Dog", "Malika", "10/22/2020", "Female", "09/12/2019", "Transferred", "https://i0.wp.com/blog.frontiersin.org/wp-content/uploads/2020/01/frontiers-psychology-stray-dogs-human-cues-behavior.jpg?resize=940%2C528&ssl=1", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal10.setDisposition(disposition1);
        animalRepository.save(animal10);

        Animal animal11 = new Animal(null, "Dog", "Taro", "08/25/2015", "Male", "09/12/2019", "Transferred", "https://ichef.bbci.co.uk/news/976/cpsprodpb/387B/production/_126795441_gettyimages-979935038-170667a.jpg.webp", "Rottweiler", "Dog food", "2 scoops 2x day", "Available for Adoption", null, null);
        animal11.setDisposition(disposition1);
        animalRepository.save(animal11);

        Animal animal12 = new Animal(null, "Dog", "Ozzy", "01/03/2019", "Female", "09/12/2019", "Stray Animal", "https://media.4-paws.org/2/1/f/2/21f2e1c51bedd0a4315cf9b234a17075150c711e/VIER%20PFOTEN_2014-09-09_025-3330x2304-1300x899.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal12.setDisposition(disposition1);
        animalRepository.save(animal12);

        Animal animal13 = new Animal(null, "Dog", "Aswut", "07/12/2020", "Female", "09/12/2019", "Transferred", "https://media.4-paws.org/b/e/7/7/be7731d9adaa3878f35c565dd97dcf268443bc05/VIER%20PFOTEN_2012-05-18_009-1300x865.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal13.setDisposition(disposition1);
        animalRepository.save(animal13);

        Animal animal14 = new Animal(null, "Cat", "Eagle", "12/04/2017", "Male", "09/12/2019", "Surrender", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Ko%C4%8Dka_v_Dra%C5%A1nici.jpg/220px-Ko%C4%8Dka_v_Dra%C5%A1nici.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal14.setDisposition(disposition1);
        animalRepository.save(animal14);

        Animal animal15 = new Animal(null, "Cat", "Max", "10/29/2018", "Female", "09/12/2019", "Stray Animal", "https://www.rspcasa.org.au/wp-content/uploads/2022/09/StrayCAt-800-x-600-1024x768.png", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal15.setDisposition(disposition1);
        animalRepository.save(animal15);

        Animal animal16 = new Animal(null, "Cat", "Farao", "01/01/2020", "Male", "09/12/2019", "Surrender", "https://www.aspcapro.org/sites/default/files/styles/image_component/public/image-paragraph/cage-cat-tnr.jpg?itok=rQlSatqf", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal16.setDisposition(disposition1);
        animalRepository.save(animal16);

        Animal animal17 = new Animal(null, "Cat", "Cooper", "07/28/2019", "Female", "09/12/2019", "Surrender", "https://1stpetvet.com/wp-content/uploads/kitten-1024x683.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Available for Adoption", null, null);
        animal17.setDisposition(disposition1);
        animalRepository.save(animal7);

        Animal animal18 = new Animal(null, "Cat", "Birdie", "06/04/2015", "Male", "09/12/2019", "Surrender", "https://s30379.pcdn.co/wp-content/uploads/2019/09/p1cuv198jk1t3oief1vesoae1rnq6.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Available for Adoption", null, null);
        animal18.setDisposition(disposition1);
        animalRepository.save(animal18);

        Animal animal19 = new Animal(null, "Cat", "Bear", "07/22/2022", "Female", "09/12/2019", "Surrender", "https://southwesthumane.org/media/2032/lost-found_stray-cats-kittens.png?width=730&height=340&mode=crop", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal19.setDisposition(disposition1);
        animalRepository.save(animal19);

        Animal animal20 = new Animal(null, "Dog", "Juniper", "05/18/2018", "Male", "09/12/2019", "Surrender", "https://www.aljazeera.com/wp-content/uploads/2022/09/000_32HB9XR.jpg?resize=1170%2C780&quality=80", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal20.setDisposition(disposition1);
        animalRepository.save(animal20);

        Animal animal21 = new Animal(null, "Cat", "Felix", "30/11/2018", "Male", "09/12/2019", "Surrender", "https://d339b5nop2tkmp.cloudfront.net/uploads/pictures/2232/content_IMG_1230-1.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal21.setDisposition(disposition1);
        animalRepository.save(animal21);

        Animal animal22 = new Animal(null, "Cat", "Angel", "04/27/2021", "Male", "09/12/2019", "Surrender", "https://topdogtips.com/wp-content/uploads/2021/11/Untitled-design-2021-10-23T212440.070.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal22.setDisposition(disposition1);
        animalRepository.save(animal22);

        Animal animal23 = new Animal(null, "Dog", "Lucky", "01/15/2017", "Male", "09/12/2019", "Surrender", "https://www.sciencenews.org/wp-content/uploads/2022/04/042822_AG_dog-breeds_feats-1030x580.jpg", "Rottweiler", "Dog food", "2 scoops 2x day", "Shelter Care", null, null);
        animal23.setDisposition(disposition1);
        animalRepository.save(animal23);


        Staff staff1 = new Staff();
        staff1.setId(null);
        staff1.setEmail("grisonrf@gmail.com");
        staff1.setPassword("123test");
        staff1.setName("Rafaela Grison");
        staff1.setPhone("(720) 232-0909");
        staff1.setAddress("123 Street, 80333. Denver-CO");
        staff1.setRole("Volunteer");

        Staff staff2 = new Staff();
        staff2.setName("Sandra Olmo");
        staff2.setPassword("123test");
        staff2.setEmail("sandraolmo@hotmail.com");
        staff2.setPhone("(720) 111-5050");
        staff2.setAddress("123 Street, 80333. Denver-CO");
        staff2.setRole("Manager");

        Staff staff3 = new Staff();
        staff3.setName("Patrick Callahan");
        staff3.setPassword("123test");
        staff3.setEmail("patrickcallahan@aol.com");
        staff3.setPhone("(360) 455-9977");
        staff3.setAddress("123 Street, 80333. Denver-CO");
        staff3.setRole("Animal caretaker");

        Staff staff4 = new Staff();
        staff4.setName("Gloria Phipps");
        staff4.setPassword("123test");
        staff4.setEmail("gloriaphipps@mail.com");
        staff4.setPhone("(240) 324-1133");
        staff4.setAddress("123 Street, 80333. Denver-CO");
        staff4.setRole("Veterinarian");

        Staff staff5 = new Staff();
        staff5.setName("Dennis Johnson");
        staff5.setPassword("123test");
        staff5.setEmail("dennisjohnson@yahoo.com");
        staff5.setPhone("(240) 689-4022");
        staff5.setAddress("123 Street, 80333. Denver-CO");
        staff5.setRole("Kennel technician");
        staffRepository.saveAll(Arrays.asList(staff5, staff4, staff2, staff3 ,staff1));

        Note note1 = new Note(null, "Don't forget to call the Vet", staff1);
        noteRepository.saveAndFlush(note1);


        Staff staffTest = staffRepository.findById(1L).orElse(null);
        Task task1 = new Task(null, "Take the trash out", "Feb / 20", staff1);
        Task task2 = new Task(null, "Buy Coco's special dog food", "Feb / 20", staff2);
        Task task3 = new Task(null, "Take Fluffy to get the vaccines at 2pm", "Feb / 20", staff4);
        Task task4 = new Task(null, "Clean the kennels 1 and 2", "Feb / 20", staff3);
        Task task5 = new Task(null, "Take Lily, Kai and Max to the groomer at 10am", "Feb / 21", staff1);
        Task task6 = new Task(null, "Send last month's report to Roberta", "Feb / 21", staff3);
        Task task7 = new Task(null, "Daisy's spay surgery at 1:30pm", "Feb / 22", staff2);
        Task task8 = new Task(null, "Fix door at kannel 4", "Feb / 22", staff4);
        Task task9 = new Task(null, "Assist new volunteers", "Feb / 22", staff1);
        Task task10 = new Task(null, "Take bear for his DHPP vaccine - 11am", "Feb / 23", staff4);


        taskRepository.saveAll(Arrays.asList(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10));

    }
}
