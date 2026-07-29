package com.hospital.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="ambulance_request")
public class AmbulanceRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String patientName;

    private String phone;

    private String location;

    private String description;

    private String status;



    public AmbulanceRequest(){

    }



    public Long getId(){

        return id;

    }


    public void setId(Long id){

        this.id=id;

    }



    public String getPatientName(){

        return patientName;

    }


    public void setPatientName(String patientName){

        this.patientName=patientName;

    }



    public String getPhone(){

        return phone;

    }


    public void setPhone(String phone){

        this.phone=phone;

    }



    public String getLocation(){

        return location;

    }


    public void setLocation(String location){

        this.location=location;

    }



    public String getDescription(){

        return description;

    }


    public void setDescription(String description){

        this.description=description;

    }



    public String getStatus(){

        return status;

    }


    public void setStatus(String status){

        this.status=status;

    }


}
