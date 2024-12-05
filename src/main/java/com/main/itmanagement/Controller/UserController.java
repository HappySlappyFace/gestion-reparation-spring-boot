package com.main.itmanagement.Controller;

import com.main.itmanagement.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/login")
    public String loginPage(){
        return "Hello World";
    }

    // DTO for login request
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and Setters

        public String getUsername() {
            return username;
        }
        public String getPassword() {
            return password;
        }
    }

    // DTO for login response with token and role
    public static class AuthResponse {
        private String token;
        private String role;

        public AuthResponse(String token, String role) {
            this.token = token;
            this.role = role;
        }

        public String getToken() {
            return token;
        }

        public String getRole() {
            return role;
        }
    }
}
