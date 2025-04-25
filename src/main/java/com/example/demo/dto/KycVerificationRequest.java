package com.example.demo.dto;


public class KycVerificationRequest {

    private String name;
    private String address;
    private String country_code;

    public KycVerificationRequest(String name, String address, String country_code) {
        this.name = name;
        this.address = address;
        this.country_code = country_code;
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

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
