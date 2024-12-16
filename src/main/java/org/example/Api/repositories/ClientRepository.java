package org.example.Api.repositories;

import org.example.Api.models.Address;
import org.example.Api.models.Client;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    void saveClient(Client client);

    void deleteClient(UUID id);

    Optional<Client> findClientByNameSurname(String name, String surname);

    List<Client> findAll(int offset, int limit);

    List<Client> findAll();

    void updateClientAddress(UUID clientId, Address address);

    Optional<Client> findClientById(UUID clientId);


}
