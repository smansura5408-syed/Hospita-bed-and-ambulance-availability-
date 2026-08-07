package com.hospital.app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "*")
public class StaffController {


    @PostMapping("/login")
    public String staffLogin(@RequestBody StaffLoginRequest request) {

        // Temporary login check
        if(request.getUsername().equals("staff") &&
           request.getPassword().equals("1234")) {

            return "Login Success";

        }

        return "Invalid Username or Password";
    }


    public static class StaffLoginRequest {

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
