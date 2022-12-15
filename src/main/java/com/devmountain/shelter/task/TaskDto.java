package com.devmountain.shelter.task;

import com.devmountain.shelter.animal.AnimalDto;
import com.devmountain.shelter.staff.StaffDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Serializable {

    public Long id;
    public String task;
    public String when;

    public StaffDto staffDto;
    public AnimalDto animalDto;

    public TaskDto (Task task) {
        if (task.getId() != null){
            this.id = task.getId();
        }
        if (task.getTask() != null){
            this.task = task.getTask();
        }
        if (task.getWhen() != null){
            this.when = task.getWhen();
        }

    }
}
