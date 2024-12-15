package com.main.itmanagement.Service;

import com.main.itmanagement.Entities.Reparation;
import com.main.itmanagement.Repository.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReparationService {

    @Autowired
    private ReparationRepository reparationRepository;

    // Create a new Reparation and link it to DemandeReparation (done in controller now)
    public Reparation createReparation(Reparation reparation) {
        // The relationship is already established in the controller
        return reparationRepository.save(reparation);
    }

    // Other methods for managing Reparations, if needed
    public Reparation getReparationById(int id) {
        return reparationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reparation not found"));
    }

    public List<Reparation> getAllReparations() {
        return reparationRepository.findAll(); // Ensure `findAll()` returns a List
    }


    public void deleteReparation(int id) {
        Reparation reparation = reparationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reparation not found"));
        reparationRepository.delete(reparation);
    }
}
