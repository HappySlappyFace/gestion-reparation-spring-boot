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
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FactureService {

    private final FactureRepository factureRepository;
    private final ReparationRepository reparationRepository;

    public FactureService(FactureRepository factureRepository, ReparationRepository reparationRepository) {
        this.factureRepository = factureRepository;
        this.reparationRepository = reparationRepository;
    }

    /**
     * Generates a facture for a given repair request ID.
     *
     * @param idDemandeReparation The ID of the repair request.
     * @return FactureDTO containing the invoice details.
     */
    public FactureDTO generateFactureForRepairRequest(int idDemandeReparation) {
        // Fetch all reparations for the given repair request
        List<Reparation> reparations = reparationRepository.findByDemandeReparation_IdDemande(idDemandeReparation);

        // Check if no reparations were found
        if (reparations == null || reparations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No reparations found for Repair Request ID: " + idDemandeReparation);
        }

        // Filter valid reparations
        List<Reparation> validReparations = reparations.stream()
                .filter(rep -> rep != null && rep.getTarifHMO() > 0 && rep.getTempsMO() > 0)
                .collect(Collectors.toList());

        if (validReparations.isEmpty()) {
            throw new NoSuchElementException("No valid reparations found for Repair Request ID: " + idDemandeReparation);
        }
        double totalMontant = validReparations.stream()
                .mapToDouble(reparation -> {
                    double reparationCost = reparation.getTarifHMO() * reparation.getTempsMO();
                    System.out.println(reparation.getPiece());
                    double pieceCost = (reparation.getPiece() != null) ? reparation.getPiece().getPrixTTC() : 0.0;
                    System.out.println("Reparation Cost: " + reparationCost);
                    System.out.println("Piece Cost: " + pieceCost);
                    return reparationCost + pieceCost;
                })
                .sum();


        // Convert reparations to ReparationDTO
        List<ReparationDTO> reparationDTOs = validReparations.stream()
                .map(reparation -> {
                    ReparationDTO dto = new ReparationDTO(reparation);
                    if (reparation.getPiece() != null) {
                        dto.setPrixHT(reparation.getPiece().getPrixHT());
                        dto.setPrixTTC(reparation.getPiece().getPrixTTC());
                        dto.setPieceName(reparation.getPiece().getNom());
                    }
                    return dto;
                })
                .toList();

        // Create FactureDTO
        FactureDTO factureDTO = new FactureDTO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String formattedTimestamp = LocalDateTime.now().format(formatter);

        factureDTO.setNumero("FAC-" + formattedTimestamp);
        factureDTO.setDate(new Date());
        factureDTO.setMontantTotal(totalMontant);
        factureDTO.setReparations(reparationDTOs);

        return factureDTO;
    }
}
