package com.devmountain.shelter.animal;

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

//    @Override
//    @Transactional
//    public AnimalDto addAnimal(AnimalDto animalDto) {
//        Animal animal = new Animal(animalDto);
//
//        Optional<Animal> animalOptional = animalRepository.findById(animalDto.getId());
//        animal.setId(animalOptional.get().getId());
//
//        return new AnimalDto(animalRepository.saveAndFlush(animal));
//    }

    @Transactional
    public List<String> addAnimal(AnimalDto animalDto){
        List<String> response = new ArrayList<>();
        Animal animal = new Animal(animalDto);
        animalRepository.saveAndFlush(animal);
        response.add("Animal Added Successfully");
        return response;
    }

//    @Transactional
//    public List<String> addAnimal(List<String> animalDto){
//        List<String> response = new ArrayList<>();
//
//        AnimalDto animal = new AnimalDto();
//        animal.setName(animalDto.get(0));
//        animal.setSpecies(animalDto.get(1));
//        animal.setDob(animalDto.get(2));
//        animal.setGender(animalDto.get(3));
//        animal.setAvailability(animalDto.get(4));
//
//        Animal savedAnimal = new Animal(animal);
//        animalRepository.saveAndFlush(savedAnimal);
//        response.add("Animal Added Successfully");
//        return response;
//    }



    @Override
    public List<AnimalDto> findAllAnimals() {
        List<Animal> animalList = animalRepository.findAll();
        return animalList.stream().map(AnimalDto::new).collect(Collectors.toList());
    }


    @Override
    public AnimalDto findAnimalById(Long id){
        Animal animal = animalRepository.findById(id).get();
        AnimalDto animalDto = new AnimalDto(animal);
        return animalDto;
    }

}








