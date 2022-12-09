package com.devmountain.shelter.task;

import com.devmountain.shelter.staff.Staff;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String task;

    @Column
    public String when;

    //animal_id

    //staff_id
    @ManyToOne
    @JsonBackReference
    private Staff staffId;
}
