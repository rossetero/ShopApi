package org.example.Api.exceptions;

import java.util.UUID;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException() {
        super("Address not found");
    }

    public AddressNotFoundException(UUID id) {
        super("Address with id=" + id + " not found");
    }

}
