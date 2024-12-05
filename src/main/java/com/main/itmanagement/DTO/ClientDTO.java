// src/main/java/com/main/itmanagement/DTO/ClientDTO.java

package com.main.itmanagement.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
}
