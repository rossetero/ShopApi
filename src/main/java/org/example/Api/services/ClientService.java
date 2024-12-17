package org.example.Api.services;

import org.example.Api.dto.AddressDTO;
import org.example.Api.dto.ClientDTO;
import org.example.Api.entities.Client;

import java.util.List;
import java.util.UUID;


public interface ClientService {
    Client getClientById(UUID clientId);

    List<ClientDTO> getAllClients(int offset, int limit);

    ClientDTO getClientByNameSurname(String name, String surname);

    void saveClient(ClientDTO clientDTO);

    void deleteClientById(UUID clientId);

    void updateClientAddress(UUID clientId, AddressDTO addressDTO);


}
