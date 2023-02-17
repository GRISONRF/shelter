package com.devmountain.shelter.notes;

import com.devmountain.shelter.staff.Staff;
import com.devmountain.shelter.staff.StaffRepository;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private NoteRepository noteRepository;


    @Override
    @Transactional
    public void addNote(NoteDto noteDto, Long staffId) {
        Optional<Staff> staffOptional = staffRepository.findById(staffId);
        Note note = new Note(noteDto);
        staffOptional.ifPresent(note::setStaff);
        noteRepository.saveAndFlush(note);
    }

    @Override
    public void deleteNoteById(Long noteId) {
        Optional<Note> noteOptional = noteRepository.findById(noteId);
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }

    @Override
    public void updateNoteById(NoteDto noteDto) {
        Optional<Note> noteOptional = noteRepository.findById(noteDto.getId());
        noteOptional.ifPresent(note -> {
            note.setBody(noteDto.getBody());
            noteRepository.saveAndFlush(note);
        });
    }

    @Override
    public List<NoteDto> getAllNotesByStaffId(Long staffId) {
        Optional<Staff> staffOptional = staffRepository.findById(staffId);

        if (staffOptional.isPresent()) {
            List<Note> noteList = noteRepository.findAllByStaffEquals(staffOptional.get());

            return noteList.stream().map(note -> new NoteDto(note)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

//    @Override
//    public List<NoteDto> getAllNotesByStaffId(Long staffId) {
//        Optional<Staff> staffOptional = staffRepository.findById(staffId);
//
//        if (staffOptional.isPresent()) {
//            List<Object[]> noteList = noteRepository.getAllNotesByStaffId(staffId);
//
//            return noteList.stream()
//                    .map(note -> new NoteDto(new Note(
//                            (Long) note[0],
//                            (String) note[1],
//                            staffOptional.get())))
//                    .collect(Collectors.toList());
//        }
//        return Collections.emptyList();
//    }

//    @Override
//    public List<Object[]> getAllNotesByStaffId(Long staffId) {
//        return noteRepository.getAllNotesByStaffId(staffId);
//    }



    @Override
    public Optional<NoteDto> getNoteById(Long noteId) {
        return Optional.empty();
    }
}
