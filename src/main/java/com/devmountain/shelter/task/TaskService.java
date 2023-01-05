package com.devmountain.shelter.task;

import jakarta.transaction.Transactional;

import java.util.List;

public interface TaskService {

    List<TaskDto> findAllTasks();

    @Transactional
    List<String> addTask(TaskDto taskDto);
}
