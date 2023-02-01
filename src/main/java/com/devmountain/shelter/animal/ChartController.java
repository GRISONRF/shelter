package com.devmountain.shelter.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@ComponentScan
@Controller
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private AnimalRepository animalRepository;


    @GetMapping("/chart")
    public String chart(Model model){
        List<Animal> animals = animalRepository.findAll();
        model.addAttribute("animals", animals);
        System.out.println("**************** animals ***********");
        System.out.println(animals);
        return "chart";
    }


}
