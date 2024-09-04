package com.api.facturacion.services;

import com.api.facturacion.entities.Client;
import com.api.facturacion.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(long id) {
        return clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void delete(long id) {
        clientRepository.deleteById(id);
    }
}
