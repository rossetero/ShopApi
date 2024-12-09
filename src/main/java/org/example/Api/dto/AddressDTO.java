package org.example.Api.dto;

import java.util.UUID;


public class AddressDTO {
    private UUID id;
    private String country;
    private String city;
    private String street;


    public AddressDTO(UUID id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public UUID getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    // Сеттеры
    public void setId(UUID id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
