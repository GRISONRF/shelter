package com.devmountain.shelter.task;

import com.devmountain.shelter.staff.Staff;
import com.devmountain.shelter.staff.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private StaffRepository staffRepository;


    @Override
    public List<TaskDto> findAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(TaskDto::new).collect(Collectors.toList());
    }

    public List<Task> findAllTasksById(Long staffId){
        Optional<Staff> staffOptional = staffRepository.findById((staffId));
        if (staffOptional.isPresent()){
            List<Task> taskList2 = taskRepository.findAllByStaffEquals(staffOptional.get());
            return taskList2;
        }
        return Collections.emptyList();
    }

    @Transactional
    public List<String> addTask(TaskDto taskDto){
        System.out.println("FIRST LINE ADD TASK !!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<String> response = new ArrayList<>();
        Optional<Staff> staffOptional = staffRepository.findById(taskDto.getStaffId());
        System.out.println("STAFF? " + staffOptional);

        Task task = new Task(taskDto);
        staffOptional.ifPresentOrElse(staff -> {
            task.setStaff(staff);
        },()->{
            System.out.println("staff id not found");
            //add some logging here to understand why staff is not found.
        });

        System.out.println("****** INSIDE OF ADDTASK." + task);
        System.out.println(taskDto);
        taskRepository.saveAndFlush(task);
        response.add("Task Added Successfully");
        return response;
    }


//    @Transactional
//    @Override
//    public TaskDto addTask(TaskDto taskDto){   //changed the addTask to return a taskDto
//        Task task = new Task(taskDto);
//        Optional<Staff> staffOptional = staffRepository.findById(taskDto.getStaffId());
//        System.out.println("\n" + staffOptional);
//
//        task.setStaff(staffOptional.get());
//        return new TaskDto(taskRepository.saveAndFlush(task));
//
//    }



    @Override
    @Transactional
    public void deleteTaskById(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        taskOptional.ifPresent(task -> taskRepository.delete(task));
    }


}
