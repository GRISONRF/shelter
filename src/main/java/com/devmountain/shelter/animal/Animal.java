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
@Table (name = "Animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String adoptionStatus;

    @Column
    private int adoptionDate;

    @Column
    private String ownerName;

    @Column
    private int ownerPhone;

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

}
