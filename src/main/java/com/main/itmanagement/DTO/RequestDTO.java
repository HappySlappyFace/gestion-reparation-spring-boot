// src/main/java/com/main/itmanagement/DTO/RequestDTO.java

package com.main.itmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private Long id;
    private String hardware;
    private String model;
    private String type; // MAINTENANCE, REPAIR, CONFIGURATION
    private String status; // WAITING, REPAIRED, CANNOT_BE_REPAIRED, DELIVERED
    private String clientEmail; // Email of the client submitting the request
    private String verificationToken; // For secure access (optional)
}
