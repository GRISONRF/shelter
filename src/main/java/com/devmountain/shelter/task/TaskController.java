package com.devmountain.shelter.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
