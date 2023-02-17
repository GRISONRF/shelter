package com.devmountain.shelter.notes;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NoteService {

    @Transactional
    void addNote(NoteDto noteDto, Long staffId);

    @Transactional
    void deleteNoteById(Long noteId);

    @Transactional
    void updateNoteById(NoteDto noteDto);

    List<NoteDto> getAllNotesByStaffId(Long staffId);

    Optional<NoteDto> getNoteById(Long noteId);
}
