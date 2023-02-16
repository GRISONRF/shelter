package com.devmountain.shelter.staff;

import com.devmountain.shelter.animal.Animal;
import com.devmountain.shelter.animal.AnimalRepository;
import com.devmountain.shelter.health.Health;
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
    @Autowired
    private AnimalRepository animalRepository;



    @PostMapping("/login")
    public String staffLogin(@RequestBody StaffDto staffDto, Model model) {
        Optional<Staff> staffOptional = staffRepository.findByEmail(staffDto.getEmail());
        if (staffOptional.isPresent()){
            if(staffDto.getPassword().matches(staffOptional.get().getPassword())){
                System.out.println(" *   *   *    inside of .isPresent");

                List<Animal> animals = animalRepository.findAll(); // get the animal data
                System.out.println(animals + "****** ANIMALS <<<<<<<<<");

                model.addAttribute("animals", animals); // add the data to the model object
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
        List<Animal> animals = animalRepository.findAll();
        model.addAttribute("animals", animals);
        model.addAttribute("staff", staff);
        model.addAttribute("tasks", tasks);
        return "dashboard";
    }

    @GetMapping("/all")
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }


}
