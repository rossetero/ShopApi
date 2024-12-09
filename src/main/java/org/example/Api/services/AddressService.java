package org.example.Api.services;

import org.example.Api.dto.AddressDTO;

import java.util.UUID;

public interface AddressService {
    AddressDTO getAddressById(UUID id);
}
