package com.devmountain.shelter.staff;

import com.devmountain.shelter.notes.Note;
import com.devmountain.shelter.notes.NoteDto;
import com.devmountain.shelter.notes.NoteRepository;
import com.devmountain.shelter.task.Task;
import com.devmountain.shelter.task.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<String> addStaff(StaffDto staffDto){
        List<String> response = new ArrayList<>();
        Staff staff = new Staff(staffDto);
        staffRepository.saveAndFlush(staff);
        response.add("http://localhost:8080/staff/all-staff.html");
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

    @Transactional
    public void deleteStaff(Long staffId) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        System.out.println("*****************");
        System.out.println(staff);

        if (staff == null) {
            // Handle the case when the Staff object does not exist.
            return;
        }

//        Set<Note> notes = staff.getNoteSet();
//        System.out.println(notes);
        List<Task> tasks = taskRepository.findByStaff(staff);
        List<Note> notesDto = noteRepository.findByStaffId(staffId);
        Set<Note> notes = new HashSet<>(notesDto);

        System.out.println("tasks:");
        System.out.println(tasks);
        System.out.println("notes:");
        System.out.println(notesDto);
        notesDto.forEach(note -> note.setStaff(null));
        taskRepository.deleteAll(tasks);
        noteRepository.deleteAll(notes);
        staffRepository.deleteById(staffId);
    }




}
