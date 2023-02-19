package com.devmountain.shelter.disposition;

import org.springframework.beans.factory.annotation.Autowired;
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

        dispositionService.addDisposition(dispositionDto);
    }

}
