package org.example.Api.entities;

import java.util.Objects;
import java.util.UUID;


public class Address {
    private UUID id;
    private String country;
    private String city;
    private String street;


    public Address(UUID id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Address otherAddress = (Address) other;
        return Objects.equals(this.id, otherAddress.id)
                && Objects.equals(this.country, otherAddress.country)
                && Objects.equals(this.city, otherAddress.city)
                && Objects.equals(this.street, otherAddress.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street);
    }

    // Геттеры
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

    // Метод toString
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

}
