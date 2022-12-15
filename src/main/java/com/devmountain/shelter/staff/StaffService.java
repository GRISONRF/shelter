package com.devmountain.shelter.staff;

import java.util.List;

public interface StaffService {
    List<String> addStaff(StaffDto staffDto);

    List<String> staffLogin(StaffDto staffDto);
}
