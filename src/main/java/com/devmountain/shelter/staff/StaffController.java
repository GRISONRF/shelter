package com.devmountain.shelter.staff;

import com.devmountain.shelter.animal.AnimalDto;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private PasswordEncoder passwordEncoder;


//    @GetMapping("/login")
//    public String handleGet() {
//        return "This endpoint only supports POST requests";
//    }
//    @PostMapping("/login")
//    public ResponseEntity<List<String>> staffLogin(@RequestBody StaffDto staffDto, HttpServletResponse httpResponse, HttpSession session){
//
//        LoginResponse response = (LoginResponse) service.staffLogin(staffDto);
//        if (response.isSuccessful()) {
//            session.setAttribute("staff-id", response.getResponse().get(1));
//            System.out.println(session.getAttribute("staff-id"));
//
//            return ResponseEntity.ok().body(response.getResponse());
//        } else {
//            return ResponseEntity.badRequest().body(response.getResponse());
//        }
//
//    }

    @PostMapping(value = "/login", consumes = "application/json")
    public List<String> staffLogin(@RequestBody StaffDto staffDto){
        return staffService.staffLogin(staffDto);
    }

    @GetMapping("/staff")
    public List<StaffDto> findAllStaff(StaffDto staffDto, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/staff/all-staff.html");
//        model.addAttribute("species", staffDto.getName());

        return staffService.findAllStaff();
    }


}
