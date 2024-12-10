package org.example.Api.exceptions;

import java.util.UUID;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super("Client not found");
    }

    public ClientNotFoundException(UUID id) {
        super("Client with id=" + id + " not found");
    }

    public ClientNotFoundException(String name, String surname) {
        super("Client with name=" + name + " and surname=" + surname + " not found");
    }
}
