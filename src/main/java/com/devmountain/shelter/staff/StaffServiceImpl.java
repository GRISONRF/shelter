package com.devmountain.shelter.staff;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<String> addStaff(StaffDto staffDto){
        List<String> response = new ArrayList<>();
        Staff staff = new Staff(staffDto);
        staffRepository.saveAndFlush(staff);
        response.add("New staff added successfully");
        return response;
    }

    @Override
    public List<String> staffLogin(StaffDto staffDto){
        List<String> response = new ArrayList<>();
        Optional<Staff> staffOptional = staffRepository.findByEmail(staffDto.getEmail());
        if (staffOptional.isPresent()){
            if(passwordEncoder.matches(staffDto.getPassword(), staffOptional.get().getPassword())){
                response.add("User login successful");
                response.add(String.valueOf(staffOptional.get().getId()));
            } else {
                response.add("Email or password incorrect");
            }
        } else {
            response.add("Email or password incorrect");
        }
        return response;
    }


}
