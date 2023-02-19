package com.devmountain.shelter.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService{

    @Autowired
    private HealthRepository healthRepository;


    @Override
    public Health getHealthByAnimalId(Long animalId) {
        return healthRepository.findByAnimalId(animalId);
    }

}
