package com.api.facturacion.controllers;

import com.api.facturacion.entities.Client;
import com.api.facturacion.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/clients")
    public List<Client> findAllClients() {
        return clientService.getAll();
    }

    @GetMapping("/client/{id}")
    public Client findClientById(@PathVariable long id) {
        return clientService.getById(id);
    }

    @PostMapping("/client")
    public void saveClient(@RequestBody Client client) {
        clientService.save(client);
    }

    @PutMapping("/client")
    public void editClient(@RequestBody Client client) {
        clientService.save(client);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.delete(id);
    }
}
