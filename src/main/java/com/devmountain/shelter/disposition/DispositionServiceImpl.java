package com.devmountain.shelter.disposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositionServiceImpl implements DispositionService {

    @Autowired
    private DispositionRepository dispositionRepository;

    @Override
    public Disposition getDispositionByAnimalId(Long animalId) {
        return dispositionRepository.findByAnimalId(animalId);
    }


    public Disposition addDisposition(DispositionDto dispositionDto){

        Disposition disposition = new Disposition(dispositionDto);
        return dispositionRepository.save(disposition);

    }

}
