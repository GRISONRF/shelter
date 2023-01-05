package com.devmountain.shelter.task;

import com.devmountain.shelter.animal.AnimalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<TaskDto> findAllTasks(TaskDto taskDto, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/task/tasks.html");

        return taskService.findAllTasks();
    }


    @PostMapping(value = "/addTask", consumes = "application/json")
    public void addTask(@RequestBody TaskDto taskDto){
        taskService.addTask(taskDto);
    }
}
