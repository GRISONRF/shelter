package com.devmountain.shelter.staff;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<List<String>> staffLogin(@RequestBody StaffDto staffDto, HttpServletResponse httpResponse, HttpSession session){

        LoginResponse response = (LoginResponse) service.staffLogin(staffDto);
        if (response.isSuccessful()) {
            session.setAttribute("staff-id", response.getResponse().get(1));
            System.out.println(session.getAttribute("staff-id"));

            return ResponseEntity.ok().body(response.getResponse());
        } else {
            return ResponseEntity.badRequest().body(response.getResponse());
        }

    }
}
