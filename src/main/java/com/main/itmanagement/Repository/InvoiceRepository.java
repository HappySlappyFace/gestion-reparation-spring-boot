// src/main/java/com/main/itmanagement/Repository/InvoiceRepository.java

package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
