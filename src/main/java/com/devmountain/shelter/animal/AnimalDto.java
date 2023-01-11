package com.devmountain.shelter.animal;

import com.devmountain.shelter.task.Task;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto implements Serializable   {

    private Long id;
    private String species;
    private String name;
    private String dob ;
    private String gender;
    private String intakeDate;
    private String intakeMethod;
    private String picture;
    private String breed;
    private String food;
    private String food_amount;
    private String availability;
//    private String adoptionType;
//    private Integer adoptionDate;
//    private String ownerName;
//    private Integer ownerPhone;
//    private String ownerAddress;
//
//    private List<Task> tasks = new ArrayList<>();

    public AnimalDto(Animal animal) {
        if (animal.getId() != null){
            this.id = animal.getId();
        }
        if (animal.getSpecies() != null){
            this.species = animal.getSpecies();
        }
        if (animal.getName() != null){
            this.name = animal.getName();
        }
        if (animal.getDob() != null){
            this.dob = animal.getDob();
        }
        if (animal.getGender() != null) {
            this.gender = animal.getGender();
        }
        if (animal.getIntakeDate() != null){
            this.intakeDate = animal.getIntakeDate();
        }
        if (animal.getIntakeMethod() != null){
            this.intakeMethod = animal.getIntakeMethod();
        }
        if (animal.getPicture() != null){
            this.picture = animal.getPicture();
        }
        if (animal.getBreed() != null){
            this.breed = animal.getBreed();
        }
        if (animal.getFood() != null){
            this.food = animal.getFood();
        }
        if (animal.getFood_amount() != null){
            this.food_amount = animal.getFood_amount();
        }
        if (animal.getAvailability() != null){
            this.availability = animal.getAvailability();
        }
//        if (animal.getAdoptionDate() != null){
//            this.adoptionDate = animal.getAdoptionDate();
//        }
//        if (animal.getAdoptionType() != null){
//            this.adoptionType= animal.getAdoptionType();
//        }
//        if (animal.getOwnerName() != null){
//            this.ownerName = animal.getOwnerName();
//        }
//        if (animal.getOwnerPhone() != null){
//            this.ownerPhone = animal.getOwnerPhone();
//        }
//        if (animal.getOwnerAddress() != null){
//            this.ownerAddress = animal.getOwnerAddress();
//        }


    }

}
