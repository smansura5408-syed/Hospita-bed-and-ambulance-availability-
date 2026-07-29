package com.hospital.app.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.entity.AmbulanceRequest;
import com.hospital.app.repository.AmbulanceRepository;



@RestController
@RequestMapping("/ambulance")
@CrossOrigin("*")
public class AmbulanceController {



    private final AmbulanceRepository ambulanceRepository;



    public AmbulanceController(AmbulanceRepository ambulanceRepository){

        this.ambulanceRepository = ambulanceRepository;

    }




    @PostMapping("/request")
    public AmbulanceRequest requestAmbulance(
            @RequestBody AmbulanceRequest request){



        if(request.getStatus()==null){

            request.setStatus("PENDING");

        }



        return ambulanceRepository.save(request);


    }



}
