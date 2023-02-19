package com.devmountain.shelter.task;

import com.devmountain.shelter.staff.Staff;
import com.devmountain.shelter.staff.StaffDto;
import com.devmountain.shelter.staff.StaffRepository;
import com.devmountain.shelter.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@ComponentScan
@Controller
@RequestMapping("taskPage")
public class TaskController {

    @Autowired
    public TaskService taskService;
    @Autowired
    public StaffService staffService;

    @Autowired
    public StaffRepository staffRepository;

    @GetMapping(value="/{id}")
    public String getTasksByStaffId(@PathVariable Long id, Model model){
        StaffDto staff = staffService.findStaff(id);
        List<Task> tasks = taskService.findAllTasksById(id);
        model.addAttribute("staff", staff);
        model.addAttribute("tasks", tasks);

        return "dashboard";
    }


    @GetMapping("/newTask")
    public String newTask(Model model) {
        List<Staff> staffList = staffRepository.findAll();
        model.addAttribute("staffList", staffList);
        return "newTask";
    }

}
