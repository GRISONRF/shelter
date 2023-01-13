package com.devmountain.shelter.staff;

import com.devmountain.shelter.task.Task;
import com.devmountain.shelter.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ComponentScan
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private TaskRepository taskRepository;

//    @PostMapping("/login")
//    public String staffLogin(@RequestBody StaffDto staffDto, Model model) {
//        List<String> response = staffService.staffLogin(staffDto);
//        if (response.size() == 2) {
//            model.addAttribute("staffId", response.get(1));
//
//            System.out.println("********** staff id ***********" + response.get(1) + "*****");
//            return "redirect:" + response.get(0);
//        } else {
//            model.addAttribute("error", response.get(0));
//            return "redirect:/dashboard";
//        }
//    }

    @PostMapping("/login")
    public String staffLogin(@RequestBody StaffDto staffDto, Model model) {
        Optional<Staff> staffOptional = staffRepository.findByEmail(staffDto.getEmail());
        if (staffOptional.isPresent()){
            if(staffDto.getPassword().matches(staffOptional.get().getPassword())){
                System.out.println(" *   *   *    inside of .isPresent");
                return "redirect:/staff/dashboard?staffId="+staffOptional.get().getId();

            } else {
                model.addAttribute("error", "Email or password incorrect");
                return "redirect:/login";
            }
        } else {
            model.addAttribute("error", "Email or password incorrect");
            return "redirect:/login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam("staffId") long staffId, Model model) {
        System.out.println("Inside of dashboard!!! *******");
        Staff staff = staffRepository.findById(staffId).orElseThrow();
        List<Task> tasks = taskRepository.findByStaff(staff);
        model.addAttribute("staff", staff);
        model.addAttribute("tasks", tasks);
        return "dashboard";
    }



}
