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
    private Integer idDemande; // Flattened field for demandeReparation ID
    private String pieceName; // Part name
    private Double prixHT;    // HT price
    private Double prixTTC;   // TTC price

    // Constructor
    public ReparationDTO(Reparation reparation) {
        this.idReparation = reparation.getIdReparation();
        this.dateRep = reparation.getDateRep();
        this.description = reparation.getDescription();
        this.tarifHMO = reparation.getTarifHMO();
        this.tempsMO = reparation.getTempsMO();
        this.idDemande = reparation.getDemandeReparation() != null
                ? reparation.getDemandeReparation().getIdDemande()
                : null;

        // If a part is linked, include its price and name
//        if (reparation.getPiece() != null) {
//            this.pieceName = reparation.getPiece().getNom();
//            this.prixHT = reparation.getPiece().getPrixHT();
//            this.prixTTC = reparation.getPiece().getPrixTTC();
//        }
    }
}
