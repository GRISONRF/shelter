package com.devmountain.shelter.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @Autowired TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<TaskDto> findAllTasks(TaskDto taskDto, Model model) {
        System.out.println("************ inside of rest controller find all tasks");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/task/tasks.html");

        return taskService.findAllTasks();
    }

    @PostMapping(value = "/addTask", consumes = "application/json")
    public void addTask(@RequestBody TaskDto taskDto){
        System.out.println("************ inside of rest controller add task");
        System.out.println(taskDto.staff);

        System.out.println(taskDto);
        taskService.addTask(taskDto);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTaskById(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
    }
}
