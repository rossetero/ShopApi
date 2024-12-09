package org.example.Api.repositories;

import org.example.Api.models.Address;
import org.example.Api.models.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    void saveClient(Client client);

    void deleteClient(UUID id);

    Optional<Client> findClientByNameSurname(String name, String surname);

    List<Client> findAll(); //limit offset

    void updateClientAddress(UUID clientId, Address address);
}
