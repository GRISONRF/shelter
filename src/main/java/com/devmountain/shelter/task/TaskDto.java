package com.devmountain.shelter.task;

import com.devmountain.shelter.staff.StaffDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Serializable {

    public Long id;
    public String name;
    public String happenedAt;

    public Long staffId;

    public StaffDto staffDto;


    public TaskDto (Task task) {
        if (task.getId() != null){
            this.id = task.getId();
        }
        if (task.getName() != null){
            this.name = task.getName();
        }
        if (task.getHappenedAt() != null){
            this.happenedAt = task.getHappenedAt();
        }

        this.staffDto = new StaffDto();
        this.staffDto.setName(task.getStaff().getName());
    }

}
