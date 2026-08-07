package com.hospital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.app.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    // Search hospitals by location
    List<Hospital> findByLocationContainingIgnoreCase(String location);

}
