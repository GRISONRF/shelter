package com.devmountain.shelter.health;

import org.springframework.stereotype.Service;

@Service
public interface HealthService {

    Health getHealthByAnimalId(Long animalId);
}
