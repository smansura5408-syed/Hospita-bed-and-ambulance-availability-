package com.hospital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.app.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}
