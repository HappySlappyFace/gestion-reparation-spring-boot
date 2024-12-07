package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Custom queries can be added here
    Client findByNom(String nom);
    Client findByNumTel(String numTel);
}
