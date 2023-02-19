package com.devmountain.shelter.disposition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispositionDto implements Serializable {
    public Long id;
    public String potty;
    public String leash;
    public String kids;
    public String otherAnimals;
    public String temper;
    public String crate;

    public String comments;

    private Long animalId;

    public DispositionDto(Disposition disposition){
        if (disposition.getId() != null) {
            this.id = disposition.getId();
        }
        if (disposition.getPotty() != null) {
            this.potty = disposition.getPotty();
        }
        if (disposition.getLeash() != null) {
            this.leash = disposition.getLeash();
        }
        if (disposition.getKids() != null) {
            this.kids = disposition.getKids();
        }
        if (disposition.getOtherAnimals() != null) {
            this.otherAnimals = disposition.getOtherAnimals();
        }
        if (disposition.getTemper() != null) {
            this.temper = disposition.getTemper();
        }
        if (disposition.getCrate() != null) {
            this.crate = disposition.getCrate();
        }
        if (disposition.getComments() != null) {
            this.comments = disposition.getComments();
        }
    }


}
