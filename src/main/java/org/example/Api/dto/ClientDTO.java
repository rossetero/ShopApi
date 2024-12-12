package org.example.Api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ClientDTO {
    private UUID id;
    private String clientName;
    private String clientSurname;
    private LocalDate birthday;
    private String gender;
    private LocalDateTime registrationDate;
    private AddressDTO address;
    
    public ClientDTO(UUID id, String clientName, String clientSurname, LocalDate birthday, String gender, LocalDateTime registrationDate, AddressDTO address) {
        this.id = id;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.birthday = birthday;
        this.gender = gender;
        this.registrationDate = registrationDate;
        this.address = address;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }


}