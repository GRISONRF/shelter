package com.devmountain.shelter.disposition;

import org.springframework.stereotype.Service;

@Service
public interface DispositionService {
    Disposition getDispositionByAnimalId(Long animalId);
}
