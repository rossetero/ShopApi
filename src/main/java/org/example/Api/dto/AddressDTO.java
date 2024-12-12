package org.example.Api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.UUID;


public class AddressDTO {
    @Null(message = "ID is calculated on backend. Set this value null")
    private UUID id;
    @NotBlank(message = "Country must not be blank")
    private String country;
    @NotBlank(message = "City must not be blank")
    private String city;
    @NotBlank(message = "Street must not be blank")
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
        this.id = null;
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
