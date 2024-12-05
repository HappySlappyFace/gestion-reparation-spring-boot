package com.main.itmanagement.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String invoiceNumber;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus; // PAID, UNPAID, PENDING

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public enum PaymentStatus {
        PAID,
        UNPAID,
        PENDING
    }
}

