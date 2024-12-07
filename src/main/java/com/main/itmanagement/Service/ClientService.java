package com.main.itmanagement.Service;

import com.main.itmanagement.Entities.Client;
import com.main.itmanagement.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Method to save a new client
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    // Method to find a client by ID
    public Client findById(int id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);  // Return the client if found, or null if not
    }

    // Example method to find a client by their name
    public Client findByName(String name) {
        return clientRepository.findByNom(name);  // Assuming you add custom queries like this
    }

    // Example method to find a client by their phone number
    public Client findByPhoneNumber(String numTel) {
        return clientRepository.findByNumTel(numTel);  // Assuming you add custom queries
    }

    // Method to find all clients
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    // Additional methods for other functionalities
}
