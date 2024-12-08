package org.example.Api.repositories;

import org.example.Api.models.Address;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


public interface AddressRepository {
    Optional<Address> getAddressById(UUID id);

    void saveAddress(Address address);

    void updateAddress(Address address);

    void deleteAddress(UUID id);

}
