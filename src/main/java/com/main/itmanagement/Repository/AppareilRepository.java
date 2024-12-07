package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.Appareil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppareilRepository extends JpaRepository<Appareil, Long> {
    // Méthodes de requête personnalisées si nécessaire
}
