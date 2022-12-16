package com.devmountain.shelter.animal;

import com.devmountain.shelter.staff.StaffDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//layer is where we will actually be defining our RESTful API endpoints and creating the paths that can deliver up the information to the client that they want.
@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping("/add-animal")
    public List<String> addAnimal(AnimalDto animalDto){
        animalService.addAnimal(animalDto);
        return null;
    }

    @GetMapping
    public List<AnimalDto> findAllAnimals(AnimalDto animalDto) {
        return animalService.findAllAnimals(animalDto);
    }


}