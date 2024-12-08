package com.main.itmanagement.Controller;

import com.main.itmanagement.Entities.Appareil;
import com.main.itmanagement.Entities.Client;
import com.main.itmanagement.Entities.DemandeReparation;
import com.main.itmanagement.Service.AppareilService;
import com.main.itmanagement.Service.ClientService;
import com.main.itmanagement.Service.DemandeReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/CRUD/demandeReparation")
public class DemandeReparationController {

    @Autowired
    private DemandeReparationService demandeReparationService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AppareilService appareilService;

    // POST: Create a new DemandeReparation
    @PostMapping
    public DemandeReparation createDemandeReparation(@RequestBody DemandeReparation demandeReparation) {
        // Fetch client using the ID from the DemandeReparation (using getIdClient)
        System.out.println("idClient: "+demandeReparation.getClient().toString());
        Client client = clientService.findById(demandeReparation.getClient().getIdClient()); // Corrected to getIdClient()

        // Fetch appareil using the ID from the DemandeReparation (using getAppareil)
        Appareil appareil = appareilService.getAppareilById(demandeReparation.getAppareil().getIdAppareil()); // Corrected to getAppareil().getIdAppareil()

        // Check if either the client or appareil is not found
        if (client == null || appareil == null) {
            throw new RuntimeException("Client or Appareil not found!");
        }

        // Set the client and appareil in the demandeReparation
        demandeReparation.setClient(client);
        demandeReparation.setAppareil(appareil);

        // Save and return the DemandeReparation object
        return demandeReparationService.save(demandeReparation);
    }




    // GET: Get all DemandeReparation
    @GetMapping
    public List<DemandeReparation> getAllDemandesReparation() {
        return demandeReparationService.findAll();
    }
}
