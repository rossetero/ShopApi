package org.example.Api.services;

import org.example.Api.dto.AddressDTO;
import org.example.Api.mappers.AddressMapper;
import org.example.Api.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDTO getAddressById(UUID id) {
        //если null кидать в контроллер 404 а пока верим что все есть
        return addressMapper.toDTO(addressRepository.findAddressById(id).get());
    }
}
