package com.devmountain.shelter.disposition;

import com.devmountain.shelter.animal.AnimalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disposition")
public class DispositionController {

    @Autowired
    private DispositionService dispositionService;


    @PostMapping(value = "/add-disposition", consumes = "application/json")
    public void addDisposition(@RequestBody DispositionDto dispositionDto){
        System.out.println("::::::::::::::::::: printing disposition dto: ");
        System.out.println(dispositionDto.toString());
        dispositionService.addDisposition(dispositionDto);
    }

}
