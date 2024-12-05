// src/main/java/com/main/itmanagement/Repository/ClientRepository.java

package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
}
