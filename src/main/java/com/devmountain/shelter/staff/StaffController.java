package com.devmountain.shelter.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostMapping("/register")
//    public List<String> addStaff(@RequestMapping StaffDto staffDto){
//
//    }
}
