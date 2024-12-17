package com.main.itmanagement.DTO;

import com.main.itmanagement.Entities.Reparation;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReparationDTO {
    private int idReparation;
    private Date dateRep;
    private String description;
    private double tarifHMO;
    private int tempsMO;
    private Integer idDemande; // ID of the linked repair request
    private String pieceName;  // Part name
    private Double prixHT;     // HT price
    private Double prixTTC;    // TTC price

    // Constructor to map entity to DTO
    public ReparationDTO(Reparation reparation) {
        this.idReparation = reparation.getIdReparation();
        this.dateRep = reparation.getDateRep();
        this.description = reparation.getDescription();
        this.tarifHMO = reparation.getTarifHMO();
        this.tempsMO = reparation.getTempsMO();
        this.idDemande = reparation.getDemandeReparation() != null
                ? reparation.getDemandeReparation().getIdDemande()
                : null;
        this.pieceName = reparation.getPiece() != null ? reparation.getPiece().getNom() : null;
        this.prixHT = reparation.getPiece() != null ? reparation.getPiece().getPrixHT() : null;
        this.prixTTC = reparation.getPiece() != null ? reparation.getPiece().getPrixTTC() : null;
    }
}
