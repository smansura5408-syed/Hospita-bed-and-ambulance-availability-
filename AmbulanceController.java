package com.hospital.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.entity.AmbulanceRequest;
import com.hospital.app.repository.AmbulanceRequestRepository;

@RestController
@RequestMapping("/ambulance")
@CrossOrigin(origins="*")
public class AmbulanceController {

    private final AmbulanceRequestRepository repository;

    public AmbulanceController(AmbulanceRequestRepository repository) {
        this.repository = repository;
    }

    // Public user requests ambulance
    @PostMapping("/request")
    public AmbulanceRequest requestAmbulance(
            @RequestBody AmbulanceRequest request) {

        request.setStatus("Pending");

        return repository.save(request);
    }

    // All requests
    @GetMapping("/requests")
    public List<AmbulanceRequest> getRequests() {
        return repository.findAll();
    }

    // Requests for one hospital
    @GetMapping("/hospital/{hospitalId}")
    public List<AmbulanceRequest> getHospitalRequests(
            @PathVariable Integer hospitalId) {

        return repository.findByHospitalId(hospitalId);
    }

    // Accept / Reject
    @PutMapping("/{id}")
    public AmbulanceRequest updateStatus(
            @PathVariable Integer id,
            @RequestBody AmbulanceRequest body) {

        AmbulanceRequest request =
                repository.findById(id).orElse(null);

        if(request == null){
            return null;
        }

        request.setStatus(body.getStatus());

        return repository.save(request);
    }
}
