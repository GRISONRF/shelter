package com.devmountain.shelter.staff;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffRestController {

    @Autowired
    private StaffService staffService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private StaffRepository staffRepository;


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

}