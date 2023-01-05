package com.devmountain.shelter.staff;

import com.devmountain.shelter.animal.AnimalDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StaffService {
    @Autowired
    List<String> addStaff(StaffDto staffDto);

//    LoginResponse staffLogin(StaffDto staffDto);
    @Autowired
    List<String> staffLogin(StaffDto staffDto);

    List<StaffDto> findAllStaff();

    StaffDto findStaff(Long id);
}

