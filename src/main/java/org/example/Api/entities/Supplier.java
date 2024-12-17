package org.example.Api.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @NotNull
    private UUID id;
    private String name;
    @Column(name = "address_id")
    private UUID addressId;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Supplier(UUID id, String name, UUID addressId, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
        this.phoneNumber = phoneNumber;
    }

    // Геттеры и сеттеры
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Перегрузка метода toString
    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    // Реализация метода equals
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Supplier otherSupplier = (Supplier) other;
        return Objects.equals(this.id, otherSupplier.id)
                && Objects.equals(this.name, otherSupplier.name)
                && Objects.equals(this.addressId, otherSupplier.addressId)
                && Objects.equals(this.phoneNumber, otherSupplier.phoneNumber);
    }

    // Реализация метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressId, phoneNumber);
    }
}
