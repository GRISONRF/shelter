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


    @PostMapping("/add-animal")   //should it be a @RequestParam instead?
    public void addAnimal(@RequestPart("image") MultipartFile image, @RequestBody AnimalDto animalDto) throws IOException {

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", System.getenv("CLOUDINARY_NAME"),
                "api_key", System.getenv("CLOUDINARY_KEY"),
                "api_secret", System.getenv("CLOUDINARY_API_SECRET")
        ));
        Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
        animalDto.setPicture((String) uploadResult.get("secure_url"));
        animalService.addAnimal(animalDto);
    }


    @GetMapping("/animals")
    public List<AnimalDto> findAllAnimals(AnimalDto animalDto, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/animal/animals.html");
//        model.addAttribute("species", animalDto.getSpecies());

        return animalService.findAllAnimals();
    }

//    @RequestMapping("/animals")
//    public String getAnimals(Model model) {
//        model.addAttribute("Animal", )
//    }


//    @RequestMapping("/{animalId}")
//    public String viewAnimal(@PathVariable long animalId, Model model) {
//
//        Animal animal = animalRepository.getReferenceById(animalId);
//        model.addAttribute("animal", animal);
//        return "viewAnimal";
//    }
        @GetMapping("/animal-profile/{animalId}")
        public AnimalDto findAnimalById(@PathVariable Long animalId) {
            System.out.println("ITS GETTING HERE!!!!!");
            System.out.println("***********************************************************************");
            return animalService.findAnimalById(animalId);
        }

//        @PostMapping("/post-form-data")
//        public String handleFormData(@RequestParam("my-file") MultipartFile file) throws IOException {
//
//            System.out.println("~~~~~~~~~~~~ SAVING THE PICTURE METHOD!!!!!!!!!! ~~~~~~~~~~~~~~~");
//
//            File pic = new File("src/main/resources/image.jpg");
//            Map uploadResult = cloudinary.uploader().upload(pic, (ObjectUtils.asMap(
//                    "cloud_name", System.getenv("CLOUDINARY_NAME"),
//                    "api_key", System.getenv("CLOUDINARY_KEY"),
//                    "api_secret", System.getenv("CLOUDINARY_API_SECRET")
//            )));
//            String url = (String) uploadResult.get("url");
//
//
//
//            return "redirect:/success";
//        }

}