package org.example.Api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ClientDTO {
    @Null(message = "ID is calculated on backend. Set this value null")
    private UUID id;
    @NotBlank(message = "Name must not be blank")
    private String clientName;
    @NotBlank(message = "Surname must not be blank")
    private String clientSurname;
    @NotNull(message = "Birthdate is null")
    @Past(message = "Invalid birthdate")
    private LocalDate birthday;
    @NotNull(message = "Gender is null")
    @Pattern(regexp = "male|female", message = "Gender must be either 'male' or 'female'")
    private String gender;
    @NotNull
    @PastOrPresent(message = "Invalid registration date")
    private LocalDateTime registrationDate;
    @Valid
    @NotNull(message = "Address must be set")
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
        this.id = null;
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