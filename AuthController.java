package com.hospital.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.hospital.app.entity.User;
import com.hospital.app.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {

        String username = data.get("username");
        String password = data.get("password");

        User user = userRepository.findByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid Username or Password");
        }

        Map<String, Object> response = new HashMap<>();

        response.put("id", user.getId());
        response.put("username", user.getUsername());
        response.put("name", user.getName());
        response.put("role", user.getRole());

        // Temporary values until Hospital table is linked
        response.put("hospitalId", 1);
        response.put("hospitalName", "Saranya Hospital");

        return response;
    }
}
