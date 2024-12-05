// src/main/java/com/main/itmanagement/DTO/Auth/SignupRequest.java

package com.main.itmanagement.DTO.Auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 40, message = "Password must be between 6 and 40 characters")
    private String password;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;
}
