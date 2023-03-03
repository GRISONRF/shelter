package com.devmountain.shelter.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/api/animal")
public class AnimalRestController {
    @Autowired
    private AnimalService animalService;


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

}