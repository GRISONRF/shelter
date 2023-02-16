package com.devmountain.shelter.disposition;

import org.springframework.stereotype.Service;

@Service
public interface DispositionService {

    Disposition addDisposition(DispositionDto dispositionDto);

    Disposition getDispositionByAnimalId(Long animalId);
    
}
