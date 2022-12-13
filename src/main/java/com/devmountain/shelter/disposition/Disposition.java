package com.devmountain.shelter.disposition;


import com.devmountain.shelter.animal.Animal;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "disposition")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    @OneToOne
    private Animal animal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Disposition that = (Disposition) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
