package com.devmountain.shelter.task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Transactional
    public List<String> addTask(TaskDto taskDto){
        List<String> response = new ArrayList<>();
        Task task = new Task(taskDto);
        taskRepository.saveAndFlush(task);
        response.add("Task Added Successfully");
        return response;
    }

//    @Override
//    @Transactional
//    public List<String> addTask(TaskDto taskDto) {
//        System.out.println(taskDto);
//
//        Task task = new Task(taskDto);
//        System.out.println(taskDto.getStaffDto().name);
//        if(staffDto.getName().contains(taskDto.getStaffDto().name)) {
//            Optional<Staff> staffOptional = StaffRepository.findById(taskDto.getStaffDto().getName());
//        }
//        task.setStaff(staffOptional.get());
//
//        return new TaskDto(taskRepository.saveAndFlush(task));
//    }


    @Override
    @Transactional
    public void deleteTaskById(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        taskOptional.ifPresent(task -> taskRepository.delete(task));
    }


}
