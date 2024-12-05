// src/main/java/com/main/itmanagement/Repository/RequestRepository.java

package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByClientEmail(String clientEmail);
}
