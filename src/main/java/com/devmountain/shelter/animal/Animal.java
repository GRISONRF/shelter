package com.devmountain.shelter.animal;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Table;
//import javax.persistence.*;


@Entity
@jakarta.persistence.Table(name = "Animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String species;

    @Column
    private String name;

    @Column
    private int dob ;

    @Column
    private int intakeDate;

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
    private int adoptionDate;

    @Column
    private String ownerName;

    @Column
    private int ownerPhone;

    @Column
    private String ownerAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
