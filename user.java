package com.hospital.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String username;

    private String email;

    private String password;

    private String role;


    @Column(name="hospital_id")
    private Integer hospitalId;


    @Column(name="hospital_name")
    private String hospitalName;


    private String name;


    @Column(name="full_name")
    private String fullName;


    private String phone;



    public User(){

    }



    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id=id;
    }



    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username=username;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email=email;
    }



    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password=password;
    }



    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role=role;
    }



    public Integer getHospitalId() {
        return hospitalId;
    }


    public void setHospitalId(Integer hospitalId) {
        this.hospitalId=hospitalId;
    }



    public String getHospitalName() {
        return hospitalName;
    }


    public void setHospitalName(String hospitalName) {
        this.hospitalName=hospitalName;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name=name;
    }



    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName=fullName;
    }



    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone=phone;
    }

}
