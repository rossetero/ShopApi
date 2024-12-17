package org.example.Api.services;

import org.example.Api.dto.AddressDTO;
import org.example.Api.exceptions.AddressNotFoundException;
import org.example.Api.mappers.AddressMapper;
import org.example.Api.entities.Address;
import org.example.Api.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDTO getAddressById(UUID id) {
        return addressMapper.toDTO(addressRepository.findAddressById(id).orElseThrow(() -> new AddressNotFoundException(id)));
    }

    @Override
    public void saveAddress(AddressDTO addressDTO, UUID addressId) {
        Address address = addressMapper.toModel(addressDTO);
        address.setId(addressId);
        addressRepository.saveAddress(address);
    }

    @Override
    public void deleteAddress(UUID addressId) {
        addressRepository.deleteAddress(addressId);
    }

    @Override
    public void updateAddress(AddressDTO addressDTO, UUID addressId) {
        Address address = addressMapper.toModel(addressDTO);
        address.setId(addressId);
        addressRepository.updateAddress(address);
    }
}
