package com.devmountain.shelter.animal;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnimalService {
    @Transactional
    List<String> addAnimal(AnimalDto animalDto);

    List<AnimalDto> findAllAnimals();

    AnimalDto findAnimalById(Long animalId);

}