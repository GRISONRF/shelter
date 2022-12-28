package com.devmountain.shelter.animal;

import com.devmountain.shelter.staff.StaffDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.List;


//layer is where we will actually be defining our RESTful API endpoints and creating the paths that can deliver up the information to the client that they want.
@RestController
@RequestMapping("/api/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping(value = "/add-animal", consumes = "application/json")
//    @PostMapping(value = "/add-animal")
    public void addAnimal(@RequestBody AnimalDto animalDto){
        animalService.addAnimal(animalDto);
    }

//    @GetMapping("/animals")
//    public ModelAndView findAllAnimals() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/animal/animals.html");
//        return modelAndView;
//    }

//    @GetMapping("/animals")
//    public String testAnimals(){
//        return "animals";
//    }

}