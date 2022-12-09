package com.devmountain.shelter.health;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "health")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Health {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String spayed;

    @Column
    public String stool;

    @Column
    public float weight;

    @Column
    public String allergy;

    @Column
    public String disability;

    @Column
    public String quarantine;

    @Column
    public String medicalRest;

    //animal_id
}
