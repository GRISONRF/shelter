package com.devmountain.shelter.animal;


import com.devmountain.shelter.disposition.Disposition;
import com.devmountain.shelter.disposition.DispositionService;
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
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private DispositionService dispositionService;


    @GetMapping(value = "/{id}")
    public String getAnimalId(@PathVariable Long id, Model model) {
        System.out.println("inside get animal id");
        AnimalDto animal = animalService.findAnimalById(id);
        model.addAttribute("animal", animal);

        Disposition disposition = dispositionService.getDispositionByAnimalId(id);
        model.addAttribute("disposition", disposition);

        return "animal-profile";
    }

}
