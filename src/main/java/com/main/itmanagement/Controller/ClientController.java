package com.main.itmanagement.Controller;

import com.main.itmanagement.Entities.Client;
import com.main.itmanagement.Repository.ClientRepository;
import com.main.itmanagement.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/CRUD/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client savedClient = clientService.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id " + id));
    }

    @GetMapping  // New method to fetch all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client client) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id " + id));
        existingClient.setNom(client.getNom());
        existingClient.setNumTel(client.getNumTel());
        existingClient.setEmail(client.getEmail());
        clientRepository.save(existingClient);
        System.out.println("Client updated: " + existingClient);  // Add logging
        return ResponseEntity.ok(existingClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id) {
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // other endpoints (GET, PUT, DELETE)
}
