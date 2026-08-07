package com.hospital.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.entity.Hospital;
import com.hospital.app.repository.HospitalRepository;

@RestController
@RequestMapping("/hospitals")
@CrossOrigin(origins = "*")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    // Get all hospitals
    @GetMapping
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    // Get hospital by ID
    @GetMapping("/{id}")
    public Hospital getHospital(@PathVariable Integer id) {
        return hospitalRepository.findById(id).orElse(null);
    }

   // Search hospitals by location
@GetMapping("/search")
public List<Hospital> searchHospital(@RequestParam String location) {
    return hospitalRepository.findByLocationContainingIgnoreCase(location);
}

    // Update hospital details
    @PutMapping("/{id}")
    public Hospital updateHospital(
            @PathVariable Integer id,
            @RequestBody Hospital hospital) {

        Hospital h = hospitalRepository.findById(id).orElse(null);

        if (h == null) {
            return null;
        }
        
        h.setName(hospital.getName());
        h.setAddress(hospital.getAddress());
        h.setCity(hospital.getCity());
        h.setPhone(hospital.getPhone());
        h.setLocation(hospital.getLocation());
        return hospitalRepository.save(h);
    }

    // Update bed availability
    @PutMapping("/{id}/beds")
    public Hospital updateBeds(
            @PathVariable Integer id,
            @RequestBody Hospital hospital) {

        Hospital h = hospitalRepository.findById(id).orElse(null);

        if (h == null) {
            return null;
        }

        h.setTotalBeds(hospital.getTotalBeds());
        h.setAvailableBeds(hospital.getAvailableBeds());

        return hospitalRepository.save(h);
    }

    // Update ambulance availability
    @PutMapping("/{id}/ambulances")
    public Hospital updateAmbulances(
            @PathVariable Integer id,
            @RequestBody Hospital hospital) {

        Hospital h = hospitalRepository.findById(id).orElse(null);

        if (h == null) {
            return null;
        }

        h.setTotalAmbulances(hospital.getTotalAmbulances());
        h.setAvailableAmbulances(hospital.getAvailableAmbulances());

        return hospitalRepository.save(h);
    }

}
