// src/main/java/com/main/itmanagement/DTO/Auth/LoginResponse.java

package com.main.itmanagement.DTO.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String tokenType = "Bearer";
}
