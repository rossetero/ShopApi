package org.example.Api.controllers;

import jakarta.validation.Valid;
import org.example.Api.dto.AddressDTO;
import org.example.Api.dto.ClientDTO;
import org.example.Api.dto.ServerResponseDTO;
import org.example.Api.exceptions.ClientNotFoundException;
import org.example.Api.models.Address;
import org.example.Api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getAllClients")
    public ResponseEntity<List<ClientDTO>> getAllClients(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "0") int limit) {
        List<ClientDTO> c = clientService.getAllClients(offset, limit);
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
    public ResponseEntity<ServerResponseDTO> addClientWithAddress(@Valid @RequestBody ClientDTO clientDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServerResponseDTO(HttpStatus.NOT_FOUND.value(), errors.toString()));
        }

        clientService.saveClient(clientDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ServerResponseDTO(HttpStatus.OK.value(), "Client created successfully"));
    }

    @DeleteMapping("/deleteClientById")
    public ResponseEntity<ServerResponseDTO> deleteClientById(@RequestParam UUID clientId){
        try{
            clientService.deleteClientById(clientId);
            return ResponseEntity.status(HttpStatus.OK).body(new ServerResponseDTO(HttpStatus.OK.value(),"Client deleted successfully"));
        }catch (ClientNotFoundException cne){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ServerResponseDTO(HttpStatus.NOT_FOUND.value(),cne.getMessage()));
        }
        //MethodArgumentTypeMismatch ловить в contoller advice
    }

    @PatchMapping("/updateClientAddressById")
    public ResponseEntity<ServerResponseDTO> updateClientAddressById(@RequestParam UUID clientId, @Valid @RequestBody AddressDTO addressDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ServerResponseDTO(HttpStatus.BAD_REQUEST.value(), errors.toString()));
        }
        try {
            clientService.updateClientAddress(clientId, addressDTO);
        } catch (ClientNotFoundException cne){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ServerResponseDTO(HttpStatus.NOT_FOUND.value(), cne.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new ServerResponseDTO(HttpStatus.OK.value(), "Address updated successfully"));
    }


}
