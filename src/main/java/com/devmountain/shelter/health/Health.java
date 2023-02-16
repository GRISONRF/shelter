package com.devmountain.shelter.health;


import com.devmountain.shelter.animal.Animal;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String spayed;

    @Column
    public String stool;

    @Column
    public String weight;

    @Column
    public String allergy;

    @Column
    public String disability;

    @Column
    public String quarantine;

    @Column
    public String medicalRest;

    //animal_id
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Health (HealthDto healthDto) {
        if (healthDto.getSpayed() != null) {
            this.spayed = healthDto.getSpayed();
        }
        if (healthDto.getStool() != null) {
            this.stool = healthDto.getStool();
        }
        if (healthDto.getWeight() != null) {
            this.weight = healthDto.getWeight();
        }
        if (healthDto.getAllergy() != null) {
            this.allergy = healthDto.getAllergy();
        }
        if (healthDto.getDisability() != null) {
            this.disability = healthDto.getDisability();
        }
        if (healthDto.getQuarantine() != null) {
            this.quarantine = healthDto.getQuarantine();
        }
        if (healthDto.getMedicalRest() != null) {
            this.medicalRest = healthDto.getMedicalRest();
        }
    }
}
