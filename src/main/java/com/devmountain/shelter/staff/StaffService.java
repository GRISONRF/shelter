package com.devmountain.shelter.staff;

import com.devmountain.shelter.animal.AnimalDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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

