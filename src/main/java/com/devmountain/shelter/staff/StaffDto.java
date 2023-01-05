package com.devmountain.shelter.staff;

import com.devmountain.shelter.task.Task;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto implements Serializable {

    public Long id;
    private String email;
    private String password;

    public String name;
    public String phone ;
    public String address;
    public String role;

    public List<Task> tasks = new ArrayList<>();

    public StaffDto (Staff staff){
        if (staff.getId() != null){
            this.id = staff.getId();
        }
        if (staff.getEmail() != null){
            this.email = staff.getEmail();
        }
        if (staff.getPassword() != null){
            this.password = staff.getPassword();
        }
        if (staff.getName() != null){
            this.name = staff.getName();
        }
        if (staff.getPhone() != null){
            this.phone = staff.getPhone();
        }
        if (staff.getAddress() != null){
            this.address = staff.getAddress();
        }
        if (staff.getRole() != null){
            this.role = staff.getRole();
        }

    }
}
