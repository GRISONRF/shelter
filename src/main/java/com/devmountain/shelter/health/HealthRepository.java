package com.devmountain.shelter.health;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<Health, Long> {

    Health findByAnimalId(Long id);
}
