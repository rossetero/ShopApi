package org.example.Api.controllers;

import jakarta.validation.Valid;
import org.example.Api.dto.ClientDTO;
import org.example.Api.dto.ServerResponseDTO;
import org.example.Api.exceptions.ClientNotFoundException;
import org.example.Api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ServerResponseDTO(HttpStatus.NOT_FOUND.value(), cne.getMessage()));
        }
    }

    @PostMapping("/addClientWithAddress")
    public ResponseEntity<?> addClientWithAddress(@Valid @RequestBody ClientDTO clientDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ServerResponseDTO(HttpStatus.NOT_FOUND.value(), errors.toString()));
        }

        clientService.saveClient(clientDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ServerResponseDTO(HttpStatus.OK.value(), "User created successfully"));
    }


}
