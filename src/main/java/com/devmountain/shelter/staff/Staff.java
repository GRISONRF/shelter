package com.devmountain.shelter.staff;

import com.devmountain.shelter.notes.Note;
import com.devmountain.shelter.task.Task;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column
    public String name;
    @Column
    public String phone;
    @Column
    public String address;
    @Column
    public String role;

    @OneToMany(mappedBy = "staff", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Note> noteSet = new HashSet<>();


    public Staff (StaffDto staffDto){
        if (staffDto.getEmail() != null) {
            this.email = staffDto.getEmail();
        }
        if (staffDto.getPassword() != null) {
            this.password = staffDto.getPassword();
        }
        if (staffDto.getName() != null) {
            this.name = staffDto.getName();
        }
        if (staffDto.getPhone() != null) {
            this.phone = staffDto.getPhone();
        }
        if (staffDto.getAddress() != null) {
            this.address = staffDto.getAddress();
        }
        if (staffDto.getRole() != null) {
            this.role = staffDto.getRole();
        }

    }
}
