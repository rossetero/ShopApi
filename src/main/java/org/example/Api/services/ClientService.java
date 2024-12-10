package org.example.Api.services;

import org.example.Api.dto.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {
    public List<ClientDTO> getAllClients();

    public ClientDTO getClientByNameSurname(String name, String surname);
}
