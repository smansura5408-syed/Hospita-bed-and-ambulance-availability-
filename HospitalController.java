package com.hospital.app.controller;

import org.springframework.web.bind.annotation.*;

import com.hospital.app.entity.Hospital;
import com.hospital.app.repository.HospitalRepository;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
@CrossOrigin(origins = "*")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hospital getHospital(@PathVariable Integer id) {
        return hospitalRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Hospital updateHospital(@PathVariable Integer id,
                                   @RequestBody Hospital hospital) {

        Hospital h = hospitalRepository.findById(id).orElse(new Hospital());

        h.setName(hospital.getName());
        h.setAddress(hospital.getAddress());
        h.setCity(hospital.getCity());
        h.setPhone(hospital.getPhone());

        return hospitalRepository.save(h);
    }

    @PutMapping("/{id}/beds")
    public Hospital updateBeds(@PathVariable Integer id,
                               @RequestBody Hospital hospital) {

        Hospital h = hospitalRepository.findById(id).orElse(new Hospital());

        h.setTotalBeds(hospital.getTotalBeds());
        h.setAvailableBeds(hospital.getAvailableBeds());

        return hospitalRepository.save(h);
    }

    @PutMapping("/{id}/ambulances")
    public Hospital updateAmbulances(@PathVariable Integer id,
                                     @RequestBody Hospital hospital) {

        Hospital h = hospitalRepository.findById(id).orElse(new Hospital());

        h.setTotalAmbulances(hospital.getTotalAmbulances());
        h.setAvailableAmbulances(hospital.getAvailableAmbulances());

        return hospitalRepository.save(h);
    }
}
