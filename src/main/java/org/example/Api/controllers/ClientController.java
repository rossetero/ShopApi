package org.example.Api.controllers;

import org.example.Api.dto.ClientDTO;
import org.example.Api.dto.ErrorResponseDTO;
import org.example.Api.exceptions.ClientNotFoundException;
import org.example.Api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> c = clientService.getAllClients();
        return ResponseEntity.ok(c);
    }

    @GetMapping("/getClientByNameSurname")
    public ResponseEntity<?> getClientByNameSurname(@RequestParam String name, @RequestParam String surname) {
        try {
            ClientDTO clientDTO = clientService.getClientByNameSurname(name, surname);
            return ResponseEntity.ok(clientDTO);
        } catch (ClientNotFoundException cne) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDTO(HttpStatus.NOT_FOUND.value(), cne.getMessage()));
        }
    }


}
