package com.hospital.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);

        System.out.println("====================================");
        System.out.println(" Hospital Availability System Started ");
        System.out.println(" Server Running : http://localhost:8081");
        System.out.println("====================================");

    }

}
