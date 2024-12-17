package com.main.itmanagement.Service;

import com.main.itmanagement.DTO.FactureDTO;
import com.main.itmanagement.DTO.ReparationDTO;
import com.main.itmanagement.Entities.Facture;
import com.main.itmanagement.Entities.Reparation;
import com.main.itmanagement.Repository.FactureRepository;
import com.main.itmanagement.Repository.ReparationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public FactureDTO generateFactureForRepairRequest(int idDemandeReparation) {
        List<Reparation> reparations = reparationRepository.findByDemandeReparation_IdDemande(idDemandeReparation);

        if (reparations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No reparations found for Repair Request ID: " + idDemandeReparation);
        }

        double totalMontant = reparations.stream()
                .mapToDouble(reparation -> {
                    double reparationCost = reparation.getTarifHMO() * reparation.getTempsMO();
                    double pieceCost = reparation.getPiece() != null ? reparation.getPiece().getPrixTTC() : 0;
                    return reparationCost + pieceCost;
                })
                .sum();

        List<ReparationDTO> reparationDTOs = reparations.stream()
                .map(ReparationDTO::new)
                .toList();

        FactureDTO factureDTO = new FactureDTO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String formattedTimestamp = LocalDateTime.now().format(formatter);
        factureDTO.setNumero("FAC-" + formattedTimestamp);        factureDTO.setDate(new Date());
        factureDTO.setMontantTotal(totalMontant);
        factureDTO.setReparations(reparationDTOs);

        return factureDTO;
    }


}
