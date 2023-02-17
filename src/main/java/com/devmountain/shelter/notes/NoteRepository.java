package com.devmountain.shelter.notes;

import com.devmountain.shelter.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByStaffEquals(Staff staff);

    List<NoteDto> getAllNotesByStaffId(long staffId);


//    @Query("SELECT n.id, n.note FROM Note n WHERE n.staff.id = :staffId")
//    List<Object[]> getAllNotesByStaffId(@Param("staffId") Long staffId);
}
