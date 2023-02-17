package com.devmountain.shelter.notes;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NoteService {

    @Transactional
    public void addNote(NoteDto noteDto, Long staffId);

    @Transactional
    public void deleteNoteById(Long noteId);

    @Transactional
    public void updateNoteById(NoteDto noteDto);

    public List<NoteDto> getAllNotesByStaffId(Long staffId);

    public Optional<NoteDto> getNoteById(Long noteId);
}
