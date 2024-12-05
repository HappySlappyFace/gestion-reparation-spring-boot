package com.main.itmanagement.Service;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "secret";  // Use a stronger key in production
    private final long EXPIRATION_TIME = 86400000;  // 24 hours in milliseconds

}
