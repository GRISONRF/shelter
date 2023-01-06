package com.devmountain.shelter.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<String> staffLogin(StaffDto staffDto){
        System.out.println(staffDto);

        List<String> response = new ArrayList<>();
        Optional<Staff> staffOptional = staffRepository.findByEmail(staffDto.getEmail());

        if (staffOptional.isPresent()){
            if(staffDto.getPassword().matches(staffOptional.get().getPassword())){
                response.add("http://localhost:8080/dashboard/dashboard.html");
                response.add(String.valueOf(staffOptional.get().getId()));
            } else {
                response.add("Email or password incorrect");
            }
        } else {
            response.add("Email or password incorrect");
        }
        return response;
    }



//    public LoginResponse staffLogin(StaffDto staffDto) {
//        System.out.println(staffDto);
//        LoginResponse response = new LoginResponse();
//        Optional<Staff> staffOptional = staffRepository.findByEmail(staffDto.getEmail());
//        if(staffOptional.isPresent()) {
//            if(staffDto.getPassword().equals(staffOptional.get().getPassword())) {
////            if(passwordEncoder.matches(staffDto.getPassword(), staffOptional.get().getPassword())) {
//                response.setSuccessful(true);
//                response.setResponse(List.of("http://localhost:8080/",String.valueOf(staffOptional.get().getId())));
//            } else {
//                response.setSuccessful(false);
//                response.setResponse(List.of("Email or password incorrect"));
//            }
//        } else {
//            response.setSuccessful(false);
//            response.setResponse(List.of("Email or password incorrect"));
//
//        }
//        System.out.println(response);
//        return response;
//    }

    @Override
    public List<StaffDto> findAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream().map(StaffDto::new).collect(Collectors.toList());
    }

    @Override
    public StaffDto findStaff(Long id) {
        Staff staff = staffRepository.findById(id).get();

        StaffDto staffDto = new StaffDto(staff);

        return staffDto;
    }


}
