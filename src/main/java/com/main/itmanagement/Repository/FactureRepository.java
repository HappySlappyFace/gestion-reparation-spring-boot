package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {
    // You can add custom queries here if needed
}
