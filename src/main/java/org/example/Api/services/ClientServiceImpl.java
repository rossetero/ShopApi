package org.example.Api.services;

import org.example.Api.dto.AddressDTO;
import org.example.Api.dto.ClientDTO;
import org.example.Api.exceptions.ClientNotFoundException;
import org.example.Api.mappers.ClientMapper;
import org.example.Api.models.Address;
import org.example.Api.models.Client;
import org.example.Api.repositories.AddressRepository;
import org.example.Api.repositories.ClientRepository;
import org.example.Api.repositories.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final AddressService addressService;

    @Autowired
    public ClientServiceImpl(ClientRepositoryImpl clientRepository, ClientMapper clientMapper, AddressService addressService) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.addressService = addressService;
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(client -> {
                    AddressDTO addressDTO = addressService.getAddressById(client.getAddressId());
                    return clientMapper.toDTO(client, addressDTO);
                })
                .toList();
    }

    @Override
    public ClientDTO getClientByNameSurname(String name, String surname) {
        Client client = clientRepository.findClientByNameSurname(name, surname).orElseThrow(() -> new ClientNotFoundException(name, surname));
        return clientMapper.toDTO(client, addressService.getAddressById(client.getAddressId()));
    }

}
