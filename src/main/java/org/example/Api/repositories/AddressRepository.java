package org.example.Api.repositories;

import org.example.Api.entities.Address;

import java.util.Optional;
import java.util.UUID;


public interface AddressRepository {
    Optional<Address> findAddressById(UUID id);

    void saveAddress(Address address);

    void updateAddress(Address address);

    void deleteAddress(UUID id);

}
