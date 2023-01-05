package com.devmountain.shelter.staff;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StaffService {
    @Autowired
    List<String> addStaff(StaffDto staffDto);

    LoginResponse staffLogin(StaffDto staffDto);
}

