package com.devmountain.shelter.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan
@Controller
@RequestMapping("/animalPage")
public class AnimalController {
    @Autowired
    private AnimalService animalService;


    @GetMapping(value = "/{id}")
    public String getAnimalId(@PathVariable Long id, Model model) {
        AnimalDto animal = animalService.findAnimalById(id);
        model.addAttribute("animal", animal);
        return "animal-profile";
    }


}
