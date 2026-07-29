package com.hospital.app.entity;

import jakarta.persistence.*;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    private String city;

    private String phone;

    private int totalBeds;

    private int availableBeds;

    private int totalAmbulances;

    private int availableAmbulances;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    public int getTotalAmbulances() {
        return totalAmbulances;
    }

    public void setTotalAmbulances(int totalAmbulances) {
        this.totalAmbulances = totalAmbulances;
    }

    public int getAvailableAmbulances() {
        return availableAmbulances;
    }

    public void setAvailableAmbulances(int availableAmbulances) {
        this.availableAmbulances = availableAmbulances;
    }
}
