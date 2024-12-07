package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.DemandeReparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeReparationRepository extends JpaRepository<DemandeReparation, Integer> {
}
