package com.devmountain.shelter.task;

import com.devmountain.shelter.animal.Animal;
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
    public String name;
    @Column
    public String happenedAt;


    //staff_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="staff_id")
    @JsonBackReference
    private Staff staff;

    public Task(TaskDto taskDto){
        if (taskDto.getName() != null) {
            this.name = taskDto.getName();
        }
        if (taskDto.getHappenedAt() != null) {
            this.happenedAt = taskDto.getHappenedAt();
        }
    }
}
