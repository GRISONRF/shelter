package com.devmountain.shelter.animal;


import com.devmountain.shelter.disposition.Disposition;
import com.devmountain.shelter.health.Health;
import com.devmountain.shelter.task.Task;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "Animal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String species;

    @Column
    private String name;

    @Column
    private Integer dob ;

    @Column
    private Integer intakeDate;

    @Column
    private String intakeMethod;

    @Column
    private String picture;

    @Column
    private String breed;

    @Column
    private String food;

    @Column
    private String food_amount;

    @Column
    private String availability;

    @Column
    private String adoptionType;

    @Column
    private Integer adoptionDate;

    @Column
    private String ownerName;

    @Column
    private Integer ownerPhone;

    @Column
    private String ownerAddress;

    //disposition
    @OneToOne
    private Disposition disposition;

    //health
    @OneToOne
    private Health health;

    //task
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Task> tasks = new ArrayList<>();

    public Animal(AnimalDto animalDto){
        if (animalDto.getSpecies() != null) {
            this.species = animalDto.getSpecies();
        }
        if (animalDto.getName() != null) {
            this.name = animalDto.getName();
        }
        if (animalDto.getDob() != null) {
            this.dob = animalDto.getDob();
        }
        if (animalDto.getIntakeDate() != null) {
            this.intakeDate = animalDto.getIntakeDate();
        }
        if (animalDto.getIntakeMethod() != null) {
            this.intakeMethod = animalDto.getIntakeMethod();
        }
        if (animalDto.getPicture() != null) {
            this.picture = animalDto.getPicture();
        }
        if (animalDto.getBreed() != null) {
            this.breed = animalDto.getBreed();
        }
        if (animalDto.getFood() != null) {
            this.food = animalDto.getFood();
        }
        if (animalDto.getFood_amount() != null) {
            this.food_amount = animalDto.getFood_amount();
        }
        if (animalDto.getAvailability() != null) {
            this.availability = animalDto.getAvailability();
        }
        if (animalDto.getAdoptionType() != null) {
            this.adoptionType = animalDto.getAdoptionType();
        }
        if (animalDto.getAdoptionDate() != null) {
            this.adoptionDate = animalDto.getAdoptionDate();
        }
        if (animalDto.getOwnerName() != null) {
            this.ownerName = animalDto.getOwnerName();
        }
        if (animalDto.getOwnerPhone() != null) {
            this.ownerPhone = animalDto.getOwnerPhone();
        }
        if (animalDto.getOwnerAddress() != null) {
            this.ownerAddress = animalDto.getOwnerAddress();
        }

    }

}
