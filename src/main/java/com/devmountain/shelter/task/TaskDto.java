package com.devmountain.shelter.task;

import jakarta.persistence.Column;

import java.io.Serializable;

public class TaskDto implements Serializable {

    public Long id;
    public String task;
    public String when;

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
