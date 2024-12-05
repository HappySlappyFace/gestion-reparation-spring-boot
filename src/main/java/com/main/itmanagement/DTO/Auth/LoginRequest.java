// src/main/java/com/main/itmanagement/DTO/Auth/LoginRequest.java

package com.main.itmanagement.DTO.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;
}
