package com.devmountain.shelter.staff;

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
        response.add("http://localhost:8080/staff/login");
        return response;
    }

//    @Override
//    public List<String> staffLogin(StaffDto staffDto){
//        System.out.println(staffDto);
//        List<String> response = new ArrayList<>();
//        Optional<Staff> staffOptional = staffRepository.findByEmail(staffDto.getEmail());
//        if (staffOptional.isPresent()){
//            if(passwordEncoder.matches(staffDto.getPassword(), staffOptional.get().getPassword())){
//                response.add("User login successful");
//                response.add(String.valueOf(staffOptional.get().getId()));
//            } else {
//                response.add("Email or password incorrect");
//            }
//        } else {
//            response.add("Email or password incorrect");
//        }
//        return response;
//    }


    public LoginResponse staffLogin(StaffDto staffDto) {
        System.out.println(staffDto);
        LoginResponse response = new LoginResponse();
        Optional<Staff> userOptional = staffRepository.findByEmail(staffDto.getEmail());
        if(userOptional.isPresent()) {
            if(staffDto.getPassword().equals(userOptional.get().getPassword())) {
//            if(passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                response.setSuccessful(true);
                response.setResponse(List.of("http://localhost:8080/",String.valueOf(userOptional.get().getId())));
            } else {
                response.setSuccessful(false);
                response.setResponse(List.of("Email or password incorrect"));
            }
        } else {
            response.setSuccessful(false);
            response.setResponse(List.of("Email or password incorrect"));

        }
        System.out.println(response);
        return response;
    }




}
