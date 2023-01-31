package com.devmountain.shelter.disposition;


import com.devmountain.shelter.animal.Animal;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "disposition")
@Data
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
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

//    @OneToOne
//    @JoinColumn(name = "animal_id")
//    private Animal animal;


    public Disposition (DispositionDto dispositionDto){
        if (dispositionDto.getPotty() != null) {
            this.potty = dispositionDto.getPotty();
        }
        if (dispositionDto.getLeash() != null) {
            this.leash = dispositionDto.getLeash();
        }
        if (dispositionDto.getKids() != null) {
            this.kids = dispositionDto.getKids();
        }
        if (dispositionDto.getOtherAnimals() != null) {
            this.otherAnimals = dispositionDto.getOtherAnimals();
        }
        if (dispositionDto.getTemper() != null) {
            this.temper = dispositionDto.getTemper();
        }
        if (dispositionDto.getCrate() != null) {
            this.crate = dispositionDto.getCrate();
        }
        if (dispositionDto.getComments() != null) {
            this.comments = dispositionDto.getComments();
        }

    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Disposition that = (Disposition) o;
//        return id != null && Objects.equals(id, that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
}
