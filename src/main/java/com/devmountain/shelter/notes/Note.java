package com.devmountain.shelter.notes;

import com.devmountain.shelter.staff.Staff;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne
    @JsonBackReference
    private Staff staff;

    public Note(NoteDto noteDto){
        if(noteDto.getBody() != null) {
            this.body = noteDto.getBody();
        }
    }

}
