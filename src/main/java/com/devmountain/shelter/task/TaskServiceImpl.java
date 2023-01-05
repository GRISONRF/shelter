package com.devmountain.shelter.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDto> findAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(TaskDto::new).collect(Collectors.toList());
    }


}
