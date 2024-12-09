package org.example.Api.mappers;

import org.example.Api.dto.AddressDTO;
import org.example.Api.dto.ClientDTO;
import org.example.Api.models.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO toDTO(Address address) {
        return new AddressDTO(address.getId(), address.getCountry(), address.getCity(), address.getStreet());
    }

    public Address toModel(AddressDTO addressDTO) {
        return new Address(addressDTO.getId(), addressDTO.getCountry(), addressDTO.getCity(), addressDTO.getStreet());
    }

    public Address toModelFromClientDTO(ClientDTO clientDTO) {
        AddressDTO addressDTO = clientDTO.getAddress();
        return new Address(addressDTO.getId(), addressDTO.getCountry(), addressDTO.getCity(), addressDTO.getStreet());
    }
}
