package com.devmountain.shelter.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;


    @PostMapping("/staff/{staffId}")
    public void addNote(@RequestBody NoteDto noteDto, @PathVariable Long staffId) {
        noteService.addNote(noteDto, staffId);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId) {
        noteService.deleteNoteById(noteId);
    }

    @PutMapping
    public void updateNote(@RequestBody NoteDto noteDto) {
        noteService.updateNoteById(noteDto);
    }

    @GetMapping("/staff/{staffId}")
    public List<NoteDto> getNotesByStaff(@PathVariable Long staffId) {
        return noteService.getAllNotesByStaffId(staffId);
    }

    @GetMapping("/{noteId}")
    public Optional<NoteDto> getNoteById(@PathVariable Long noteId) {
        return noteService.getNoteById(noteId);
    }
}
