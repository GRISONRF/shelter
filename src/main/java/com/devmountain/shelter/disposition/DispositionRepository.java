package com.devmountain.shelter.disposition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositionRepository extends JpaRepository<Disposition, Long> {
}
