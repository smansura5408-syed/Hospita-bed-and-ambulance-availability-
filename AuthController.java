package com.hospital.app.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="*")
public class AuthController {

   @PostMapping("/login")
public Map<String, Object> login(@RequestBody LoginRequest request) {

    Map<String, Object> response = new HashMap<>();

    // STAFF LOGIN
    if ("Saranya ".equals(request.getUsername())
            && "29022008".equals(request.getPassword())) {

        response.put("username", "Saranya Hospital");
        response.put("hospitalId", 1);
        response.put("hospitalName", "Saranya Hospital");
        response.put("role", "STAFF");

        return response;
    }

    // PUBLIC LOGIN
    if ("Arun".equals(request.getUsername())
            && "1234".equals(request.getPassword())) {

        response.put("username", "Public User");
        response.put("role", "PUBLIC");

        return response;
    }

    response.put("message", "Invalid username or password");
    response.put("role", "NONE");

    return response;
}

    public static class LoginRequest {

        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
