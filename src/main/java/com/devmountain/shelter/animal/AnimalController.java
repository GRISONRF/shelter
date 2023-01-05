package com.devmountain.shelter.animal;

import com.devmountain.shelter.staff.StaffDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public void addAnimal(@RequestBody AnimalDto animalDto){
        animalService.addAnimal(animalDto);
    }


    @GetMapping("/animals")
    public List<AnimalDto> findAllAnimals(AnimalDto animalDto, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/animal/animals.html");
        model.addAttribute("species", animalDto.getSpecies());

        return animalService.findAllAnimals();
    }

//    @RequestMapping("/animals")
//    public String getAnimals(Model model) {
//        model.addAttribute("Animal", )
//    }


    @RequestMapping("/{animalId}")
    public String viewAnimal(@PathVariable long animalId, Model model) {
        Animal animal = animalRepository.getReferenceById(animalId);
        model.addAttribute("animal", animal);
        return "viewAnimal";
    }

}