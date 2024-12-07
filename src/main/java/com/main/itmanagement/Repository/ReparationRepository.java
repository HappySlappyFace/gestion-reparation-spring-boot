package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Integer> {
    // You can add custom query methods here if needed
}
