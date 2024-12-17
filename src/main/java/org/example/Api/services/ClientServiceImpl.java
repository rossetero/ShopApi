package org.example.Api.services;

import org.example.Api.dto.AddressDTO;
import org.example.Api.dto.ClientDTO;
import org.example.Api.exceptions.ClientNotFoundException;
import org.example.Api.mappers.ClientMapper;
import org.example.Api.entities.Client;
import org.example.Api.repositories.ClientRepository;
import org.example.Api.repositories.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    public Client getClientById(UUID clientId) {
        return clientRepository.findClientById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
    }


    @Override
    public List<ClientDTO> getAllClients(int offset, int limit) {
        List<Client> clients = null;
        if (offset == 0 && limit == 0) {
            clients = clientRepository.findAll();
        } else {
            clients = clientRepository.findAll(offset, limit);
        }
        return clients.stream()
                .map(client -> {
                    AddressDTO addressDTO = addressService.getAddressById(client.getAddressId());
                    return clientMapper.toDTO(client, addressDTO);
                })
                .toList();
    }

    @Override
    public ClientDTO getClientByNameSurname(String name, String surname) {
        Client client = clientRepository.findClientByNameSurname(name, surname)
                .orElseThrow(() -> new ClientNotFoundException(name, surname));
        return clientMapper.toDTO(client, addressService.getAddressById(client.getAddressId()));
    }

    @Override
    public void saveClient(ClientDTO clientDTO) {
        UUID addressId = UUID.randomUUID();
        addressService.saveAddress(clientDTO.getAddress(), addressId);
        Client client = clientMapper.toModel(clientDTO);
        client.setId(UUID.randomUUID());
        client.setAddressId(addressId);
        client.setRegistrationDate(LocalDateTime.now());
        clientRepository.saveClient(client);


    }

    @Override
    public void deleteClientById(UUID clientId) {
        Client client = this.getClientById(clientId);
        clientRepository.deleteClient(clientId);
        addressService.deleteAddress(client.getAddressId());

    }

    @Override
    public void updateClientAddress(UUID clientId, AddressDTO addressDTO) {
        Client client = clientRepository.findClientById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
        addressService.updateAddress(addressDTO, client.getAddressId());
    }

}
