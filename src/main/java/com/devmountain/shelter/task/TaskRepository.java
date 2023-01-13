package com.devmountain.shelter.task;

import com.devmountain.shelter.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByStaffEquals(Staff staff);

    List<Task> findByStaffId(long staffId);

    List<Task> findByStaff(Staff staff);
}
