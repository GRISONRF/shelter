package com.devmountain.shelter.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl {

    @Autowired
    private AnimalRepository animalRepository;
}
