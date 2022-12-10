package com.devmountain.shelter.animal;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto implements Serializable   {

    private Long id;
    private String species;
    private String name;
    private int dob ;
    private int intakeDate;
    private String intakeMethod;
    private String picture;
    private String breed;
    private String food;
    private String food_amount;
    private String availability;
    private int adoptionDate;
    private String ownerName;
    private int ownerPhone;
    private String ownerAddress;
}
