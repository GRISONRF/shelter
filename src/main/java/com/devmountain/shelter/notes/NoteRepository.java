package com.devmountain.shelter.notes;

import com.devmountain.shelter.staff.Staff;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByStaffEquals(Staff staff);

    List<NoteDto> getAllNotesByStaffId(long staffId);

    void deleteByStaffId(Long staffId);

    @Modifying
    @Transactional
    @Query("delete from Note n")
    void deleteAllNotes();

    List<Note> findByStaffId(Long staffId);


//    @Query("SELECT n.id, n.note FROM Note n WHERE n.staff.id = :staffId")
//    List<Object[]> getAllNotesByStaffId(@Param("staffId") Long staffId);
}
