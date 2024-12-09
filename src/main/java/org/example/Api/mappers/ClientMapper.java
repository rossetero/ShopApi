package org.example.Api.mappers;

import org.example.Api.dto.AddressDTO;
import org.example.Api.dto.ClientDTO;
import org.example.Api.models.Address;
import org.example.Api.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDTO toDTO(Client client, AddressDTO address) {
        return new ClientDTO(client.getId(),
                client.getClientName(),
                client.getClientSurname(),
                client.getBirthday(),
                client.getGender(),
                client.getRegistrationDate(),
                address);
    }

    public Client toModel(ClientDTO clientDTO) {
        return new Client(clientDTO.getId(),
                clientDTO.getClientName(),
                clientDTO.getClientSurname(),
                clientDTO.getBirthday(),
                clientDTO.getGender(),
                clientDTO.getRegistrationDate(),
                clientDTO.getAddress().getId());
    }
}
