package com.devmountain.shelter.staff;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface StaffService {
    @Autowired
    List<String> addStaff(StaffDto staffDto);

    @Autowired
    List<String> staffLogin(StaffDto staffDto);

    List<StaffDto> findAllStaff();

    StaffDto findStaff(Long id);

    void deleteStaff(Long staffId);

    List<String> updateStaff(Long id, StaffDto staffDto);
}

