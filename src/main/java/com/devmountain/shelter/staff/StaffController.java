package com.devmountain.shelter.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@ComponentScan
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/login")
    public String staffLogin(@ModelAttribute StaffDto staffDto, Model model) {
        List<String> response = staffService.staffLogin(staffDto);
        if (response.size() == 2) {
            model.addAttribute("staffId", response.get(1));
            System.out.println("********** staff id ***********" + response.get(0));
            return "redirect:" + response.get(0);
        } else {
            model.addAttribute("error", response.get(0));
            return "login";
        }
    }




}
