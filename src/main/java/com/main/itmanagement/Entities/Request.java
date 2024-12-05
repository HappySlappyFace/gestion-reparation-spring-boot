package com.main.itmanagement.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String hardware;

    @Column(nullable = false)
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestType type; // MAINTENANCE, REPAIR, CONFIGURATION

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status; // WAITING, REPAIRED, CANNOT_BE_REPAIRED, DELIVERED

    @Column(nullable = false)
    private String clientEmail; // Email of the client submitting the request

    public enum RequestType {
        MAINTENANCE,
        REPAIR,
        CONFIGURATION
    }

    public enum RequestStatus {
        WAITING,
        REPAIRED,
        CANNOT_BE_REPAIRED,
        DELIVERED
    }
}

