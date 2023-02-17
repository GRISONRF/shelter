package com.devmountain.shelter.staff;

import com.devmountain.shelter.animal.Animal;
import com.devmountain.shelter.animal.AnimalRepository;
import com.devmountain.shelter.health.Health;
import com.devmountain.shelter.notes.Note;
import com.devmountain.shelter.notes.NoteDto;
import com.devmountain.shelter.notes.NoteRepository;
import com.devmountain.shelter.task.Task;
import com.devmountain.shelter.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Autowired
    private NoteRepository noteRepository;


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
//        List<NoteDto> notes = noteRepository.getAllNotesByStaffId(staffId); // retrieve notes for staffId
        //        List<Object[]> notes = noteRepository.findAllByStaffId(staffId); // retrieve notes for staffId
//        List<Object[]> notes = noteRepository.getAllNotesByStaffId(staffId);
//        List<NoteDto> noteDtos = notes.stream()
//                .map(n -> new NoteDto(new Note(
//                        (Long) n[0], // Note id
//                        (String) n[1], // Note body
//                        staff
//                )))
//                .collect(Collectors.toList());

        model.addAttribute("animals", animals);
        model.addAttribute("staff", staff);
        model.addAttribute("tasks", tasks);
//        model.addAttribute("notes", notes);

        return "dashboard";
    }

    @GetMapping("/all")
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }


}
