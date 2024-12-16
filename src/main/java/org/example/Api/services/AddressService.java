package org.example.Api.services;

import org.example.Api.dto.AddressDTO;
import org.example.Api.models.Address;

import java.util.UUID;

public interface AddressService {
    AddressDTO getAddressById(UUID id);

    void saveAddress(AddressDTO addressDTO, UUID addressId);

    void deleteAddress(UUID addressId);

    void updateAddress(AddressDTO addressDTO, UUID addressId);
}
