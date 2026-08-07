package com.hospital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.app.entity.AmbulanceRequest;

public interface AmbulanceRequestRepository extends JpaRepository<AmbulanceRequest, Integer> {

    List<AmbulanceRequest> findByHospitalId(int hospitalId);

}
