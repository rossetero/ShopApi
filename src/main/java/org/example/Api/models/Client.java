package org.example.Api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Client {
    private UUID id;
    private String clientName;
    private String clientSurname;
    private LocalDate birthday;
    private String gender;
    private LocalDate registrationDate;
    private UUID addressId;

    public Client(UUID id, String clientName, String clientSurname, LocalDate birthday, String gender, LocalDate registrationDate, UUID addressId) {
        this.id = id;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.birthday = birthday;
        this.gender = gender;
        this.registrationDate = registrationDate;
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object other){
        if(this==other) return true;
        if(other==null||getClass()!=other.getClass()) return false;
        Client otherClient = (Client) other;
        return Objects.equals(this.id,otherClient.id)
                && Objects.equals(this.clientName, otherClient.clientName)
                && Objects.equals(this.clientSurname, otherClient.clientSurname)
                && Objects.equals(this.birthday, otherClient.birthday)
                && Objects.equals(this.gender,otherClient.gender)
                && Objects.equals(this.registrationDate,otherClient.registrationDate)
                && Objects.equals(this.addressId,otherClient.addressId);

    }
    @Override
    public int hashCode(){
        return Objects.hash(id,clientName,clientSurname,birthday,gender,registrationDate,addressId);
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    // Перегрузка метода toString
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", registrationDate=" + registrationDate +
                ", addressId=" + addressId +
                '}';
    }

}