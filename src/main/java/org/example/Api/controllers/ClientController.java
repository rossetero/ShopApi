package org.example.Api.controllers;

import org.example.Api.dto.ClientDTO;
import org.example.Api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Controller
    public static class ErrorHandler implements ErrorController {

        @RequestMapping("/error")
        public String handleError() {
            // Возвращает имя вашей страницы ошибки
            return "error"; // Убедитесь, что у вас есть соответствующий шаблон
        }
    }
}
