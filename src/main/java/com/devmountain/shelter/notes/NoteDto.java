package com.devmountain.shelter.notes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto implements Serializable {
    private Long id;
    private String body;

    public NoteDto (Note note){
        if (note.getId() != null) {
            this.id = note.getId();
        }
        if (note.getBody() != null) {
            this.body = note.getBody();
        }
    }

    public void setStaff(Object o) {
    }
}
