package com.devmountain.shelter.animal;

import com.devmountain.shelter.disposition.Disposition;
import com.devmountain.shelter.disposition.DispositionDto;
import com.devmountain.shelter.disposition.DispositionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private DispositionRepository dispositionRepository;


    @Transactional
    public List<String> addAnimal(AnimalDto animalDto){
        List<String> response = new ArrayList<>();
        Animal animal = new Animal(animalDto);
        System.out.println("**********inside add animal service. ANIMAL:");

        System.out.println(animal);

        if (animalDto.getDisposition() != null) {
            DispositionDto dispositionDto = animalDto.getDisposition();
            Disposition disposition = new Disposition(dispositionDto);
            dispositionRepository.save(disposition);  // save the Disposition entity to the database
            animal.setDispositionWithAnimalId(disposition);;
//            disposition.setAnimal(animal); // set the animal object
        }

        animalRepository.saveAndFlush(animal);

        response.add("Animal Added Successfully");
        return response;
    }


    @Override
    public List<AnimalDto> findAllAnimals() {
        List<Animal> animalList = animalRepository.findAll();
        return animalList.stream().map(AnimalDto::new).collect(Collectors.toList());
    }


    @Override
    public AnimalDto findAnimalById(Long id) {
        Animal animal = animalRepository.findById(id).orElse(null);
        if (animal != null) {
            Disposition disposition = dispositionRepository.findByAnimalId(animal.getId());
            animal.setDisposition(disposition);
        }
        return new AnimalDto(animal);
    }



//    public AnimalDto findAnimalById(Long id){
//        Animal animal = animalRepository.findById(id).get();
//        if (animal != null) {
//            animal.setDisposition(dispositionRepository.findByAnimalId(animal.getId()));
//        }
//        return new AnimalDto(animal);
//    }


}








