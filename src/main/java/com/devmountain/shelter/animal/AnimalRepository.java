package com.devmountain.shelter.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
//    List<AnimalDto> findByFilter(String filter);
//
//    List<Animal> findByAvailability(boolean b);
//
//    List<Animal> findByGender(String male);
//
//    List<Animal> findBySpecies(String cat);
}
