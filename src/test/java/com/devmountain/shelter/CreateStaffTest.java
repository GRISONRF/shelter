package com.devmountain.shelter;

import com.devmountain.shelter.staff.Staff;
import com.devmountain.shelter.staff.StaffRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

@DataJpaTest
@RunWith(SpringRunner.class)
//@SpringBootTest(classes=MyApplication.class)
public class CreateStaffTest {

    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void testCreateStaff() {
        Staff user1 = new Staff();
        user1.setName("user1");
        user1.setPassword("password1");
        user1.setEmail("user1@example.com");
        user1.setAddress("Denver - CO");
        user1.setPhone("(720) 333-2121");
        user1.setRole("Volunteer");
        staffRepository.save(user1);

        Staff user2 = new Staff();
        user2.setName("user2");
        user2.setPassword("password2");
        user2.setEmail("user2@example.com");
        user1.setPhone("(720) 111-5050");
        user1.setRole("Manager");
        staffRepository.save(user2);

        Staff user3 = new Staff();
        user3.setName("user3");
        user3.setPassword("password3");
        user3.setEmail("user3@example.com");
        user1.setPhone("(360) 455-9977");
        user1.setRole("Animal caretaker");
        staffRepository.save(user3);

        Staff user4 = new Staff();
        user4.setName("user4");
        user4.setPassword("password4");
        user4.setEmail("user4@example.com");
        user1.setPhone("(240) 324-1133");
        user1.setRole("Veterinarian");
        staffRepository.save(user4);

        Staff user5 = new Staff();
        user5.setName("user5");
        user5.setPassword("password5");
        user5.setEmail("user5@example.com");
        user1.setPhone("(240) 689-4022");
        user1.setRole("Kennel technician");
        staffRepository.save(user5);

        List<Staff> users = staffRepository.findAll();
        assertThat(users).hasSize(5);
    }

}
