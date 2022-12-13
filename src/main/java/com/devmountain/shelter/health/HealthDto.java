package com.devmountain.shelter.health;

import jakarta.persistence.Column;

import java.io.Serializable;

public class HealthDto implements Serializable {
    public Long id;
    public String spayed;
    public String stool;
    public float weight;
    public String allergy;
    public String disability;
    public String quarantine;
    public String medicalRest;

    public HealthDto(Health health){
        if (health.getId() != null) {
            this.id = health.getId();
        }
        if (health.getSpayed() != null) {
            this.spayed = health.getSpayed();
        }
        if (health.getStool() != null) {
            this.stool = health.getStool();
        }
        if (health.getWeight() != null) {
            this.weight = health.getWeight();
        }
        if (health.getAllergy() != null) {
            this.allergy = health.getAllergy();
        }
        if (health.getDisability() != null) {
            this.disability = health.getDisability();
        }
        if (health.getQuarantine() != null) {
            this.quarantine = health.getQuarantine();
        }
        if (health.getMedicalRest() != null) {
            this.medicalRest = health.getMedicalRest();
        }
    }

}
