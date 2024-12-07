package com.main.itmanagement.Service;

import com.main.itmanagement.Entities.Appareil;
import com.main.itmanagement.Exception.AppareilNotFoundException;
import com.main.itmanagement.Repository.AppareilRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppareilService {

    @Autowired
    private AppareilRepository appareilRepository;

    private static final Logger logger = LoggerFactory.getLogger(AppareilService.class);

    // Enregistrer un nouvel Appareil
    public Appareil addAppareil(Appareil appareil) {
        logger.info("Ajout d'un nouvel appareil: {}", appareil.getMarque());
        return appareilRepository.save(appareil);
    }

    // Récupérer tous les Appareils
    public List<Appareil> getAllAppareils() {
        logger.info("Récupération de tous les appareils");
        return appareilRepository.findAll();
    }

    // Récupérer un Appareil par ID
    public Appareil getAppareilById(Long id) {
        logger.info("Recherche de l'appareil avec l'ID: {}", id);
        return appareilRepository.findById(id)
                .orElseThrow(() -> new AppareilNotFoundException("Appareil non trouvé avec l'ID: " + id));
    }

    // Mettre à jour un Appareil
    public Appareil updateAppareil(Long id, Appareil appareilDetails) {
        logger.info("Mise à jour de l'appareil avec l'ID: {}", id);
        Appareil existingAppareil = appareilRepository.findById(id)
                .orElseThrow(() -> new AppareilNotFoundException("Appareil non trouvé avec l'ID: " + id));

        existingAppareil.setMarque(appareilDetails.getMarque());
        existingAppareil.setModele(appareilDetails.getModele());
        existingAppareil.setNumSerie(appareilDetails.getNumSerie());
        // Mettre à jour d'autres champs si nécessaire

        return appareilRepository.save(existingAppareil);
    }

    // Supprimer un Appareil
    public void deleteAppareil(Long id) {
        logger.info("Suppression de l'appareil avec l'ID: {}", id);
        if (appareilRepository.existsById(id)) {
            appareilRepository.deleteById(id);
            logger.info("Appareil avec l'ID: {} supprimé avec succès", id);
        } else {
            throw new AppareilNotFoundException("Appareil non trouvé avec l'ID: " + id);
        }
    }
}
