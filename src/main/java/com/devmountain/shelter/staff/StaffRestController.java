package com.devmountain.shelter.staff;

import com.devmountain.shelter.notes.Note;
import com.devmountain.shelter.notes.NoteRepository;
import com.devmountain.shelter.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffRestController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private NoteRepository noteRepository;


    @GetMapping("/staff")
    public List<StaffDto> findAllStaff(StaffDto staffDto, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/staff/all-staff.html");
//        model.addAttribute("species", staffDto.getName());

        return staffService.findAllStaff();
    }

    @GetMapping("/{staffId}")
    public StaffDto findById(@PathVariable Long staffId) {
        return staffService.findStaff(staffId);
    }

    @GetMapping("/all")
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @PostMapping("/add")
    public List<String> addStaff(@RequestBody StaffDto staffDto){
        return staffService.addStaff(staffDto);
    }

    @DeleteMapping("/{staffId}")
    public void deleteStaff(@PathVariable String staffId) {
        Long id = Long.parseLong(staffId);
        System.out.println("inside delete staff method");
        staffService.deleteStaff(id);
    }

    @PutMapping("/{id}")
    public void updateStaff(@PathVariable Long id, @RequestBody StaffDto staffDto) {
        staffService.updateStaff(id, staffDto);
    }



}