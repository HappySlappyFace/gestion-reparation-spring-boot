// src/main/java/com/main/itmanagement/DTO/InvoiceDTO.java

package com.main.itmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class InvoiceDTO {
    private Long id;
    private String invoiceNumber;
    private BigDecimal amount;
    private LocalDate date;
    private String paymentStatus; // PAID, UNPAID, PENDING
    private Long clientId;
}
