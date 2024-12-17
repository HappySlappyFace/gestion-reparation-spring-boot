package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Integer> {
    List<Reparation> findByDemandeReparation_IdDemande(int idDemandeReparation);
    // You can add custom query methods here if needed
}
