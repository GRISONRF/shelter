package com.devmountain.shelter.disposition;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "disposition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String potty;

    @Column
    public String leash;

    @Column
    public String kids;

    @Column
    public String otherAnimals;

    @Column
    public String temper;

    @Column
    public String crate;

    @Column(columnDefinition = "varchar(500)")
    public String comments;

    //animal_id
}
