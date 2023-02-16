package com.devmountain.shelter.task;

import com.devmountain.shelter.staff.Staff;
import com.devmountain.shelter.staff.StaffRepository;
import jakarta.mail.MessagingException;
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

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmailSenderService emailService;
    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/tasks")
    public List<TaskDto> findAllTasks(TaskDto taskDto, Model model) {
        System.out.println("************ inside of rest controller find all tasks");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/task/tasks.html");

        return taskService.findAllTasks();
    }

    @PostMapping(value = "/addTask")
    public void addTask(@RequestBody TaskDto taskDto) throws MessagingException {
        System.out.println("************ inside of rest controller add task");
        System.out.println(taskDto.staffId);
        System.out.println(taskDto);

        //call task service to add task
        taskService.addTask(taskDto);



        //get staff name and email (userEmail)
        Staff staff = staffRepository.findById(taskDto.staffId).orElseThrow();
        String userEmail = staff.getEmail();
        String staffName = staff.getName();

        //get the task name and happenedAt
        String taskName = taskDto.name;
        String happenedAt = taskDto.happenedAt;

        //create a string body (the body of the email)
        String subject = "New task assigned to you";
        String body = "<h1> Hello " + staffName + ",</h1><br>"
                + "<h2>You have a new task assigned to you: </h2><br>"
                + "<p><b>Task</b> -> " + taskName + ".<br>"
                + "<p><b>When</b> -> " + happenedAt.toString() + "<br>"
                + "<p><i>Make sure to delete this task as soon as it's completed.</i></p>"
                + "<h2> Have a great day! </h2>";

        emailService.sendHtmlEmail(userEmail, subject, body);

    }

    @DeleteMapping("/{taskId}")
    public void deleteTaskById(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
    }
}
