package com.devmountain.shelter.staff;

import com.devmountain.shelter.task.Task;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String name;

    @Column
    public int phone ;

    @Column
    public String address;

    @Column
    public String role;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private List<Task> taskList = new ArrayList<>();
}
