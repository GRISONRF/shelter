package com.devmountain.shelter.staff;

import com.devmountain.shelter.notes.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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
        staffService.deleteStaff(id);
    }

    @PutMapping("/{id}")
    public List<StaffDto> updateStaff(@PathVariable Long id, @RequestBody StaffDto staffDto) {

        staffService.updateStaff(id, staffDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/staff/all-staff.html");
        return staffService.findAllStaff();

    }



}