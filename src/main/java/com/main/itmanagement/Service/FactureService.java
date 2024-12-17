package com.main.itmanagement.Service;

import com.main.itmanagement.DTO.FactureDTO;
import com.main.itmanagement.DTO.ReparationDTO;
import com.main.itmanagement.Entities.Reparation;
import com.main.itmanagement.Repository.FactureRepository;
import com.main.itmanagement.Repository.ReparationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureService {

    private final FactureRepository factureRepository;
    private final ReparationRepository reparationRepository;

    public FactureService(FactureRepository factureRepository, ReparationRepository reparationRepository) {
        this.factureRepository = factureRepository;
        this.reparationRepository = reparationRepository;
    }

    // Generate Facture for all Reparations of a Repair Request
    public FactureDTO generateFactureForRepairRequest(int idDemandeReparation) {
        List<Reparation> reparations = reparationRepository.findByDemandeReparation_IdDemande(idDemandeReparation);

        if (reparations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No reparations found for Repair Request ID: " + idDemandeReparation);
        }

        double montantTotal = reparations.stream()
                .mapToDouble(rep -> rep.getTarifHMO() * rep.getTempsMO())
                .sum();

        String numeroFacture = "FAC-" + System.currentTimeMillis();

        // Return a DTO containing facture summary and all reparations
        return new FactureDTO(
                numeroFacture,
                new Date(),
                montantTotal,
                reparations.stream().map(ReparationDTO::new).collect(Collectors.toList())
        );
    }

}
