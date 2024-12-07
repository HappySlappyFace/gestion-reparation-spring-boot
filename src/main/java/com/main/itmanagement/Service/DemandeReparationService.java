package com.main.itmanagement.Service;

import com.main.itmanagement.Entities.DemandeReparation;
import com.main.itmanagement.Repository.DemandeReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeReparationService {

    @Autowired
    private DemandeReparationRepository demandeReparationRepository;

    // Save a new DemandeReparation
    public DemandeReparation save(DemandeReparation demandeReparation) {
        return demandeReparationRepository.save(demandeReparation);
    }

    // Find all DemandeReparation records
    public List<DemandeReparation> findAll() {
        return demandeReparationRepository.findAll();
    }

    // Find a DemandeReparation by ID
    public DemandeReparation findById(int id) {
        return demandeReparationRepository.findById(id).orElse(null);
    }
}
