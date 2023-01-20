package com.devmountain.shelter.animal;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//layer is where we will actually be defining our RESTful API endpoints and creating the paths that can deliver up the information to the client that they want.
@RestController
@RequestMapping("/api/animal")
public class AnimalRestController {
    @Autowired
    private AnimalService animalService;
    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping(value = "/add-animal", consumes = "application/json")
    public void addAnimal(@RequestBody AnimalDto animalDto){
        System.out.println((animalDto.toString()));
        animalService.addAnimal(animalDto);
    }

    @GetMapping("/animal-profile/{animalId}")
    public AnimalDto findAnimalById(@PathVariable Long animalId) {
            return animalService.findAnimalById(animalId);
        }

    @GetMapping("/animals")
    public List<AnimalDto> findAllAnimals(AnimalDto animalDto, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/animal/animals.html");
        return animalService.findAllAnimals();
    }


//    @GetMapping("/animals")
//    public List<AnimalDto> findAnimals(@RequestParam(value = "filter", required = false) String filter) {
//        List<Animal> animals;
//        if(filter != null) {
//            if (filter.equals("cat")) {
//                animals = animalRepository.findBySpecies("cat");
//            } else if (filter.equals("dog")) {
//                animals = animalRepository.findBySpecies("dog");
//            } else {
//                animals = animalRepository.findAll();
//            }
//        } else {
//            animals = animalRepository.findAll();
//        }
//
//        List<AnimalDto> animalsDto = new ArrayList<>();
//        for (Animal animal : animals) {
//            animalsDto.add(new AnimalDto(animal));
//        }
//        return animalsDto;
//    }



}