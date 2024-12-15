package com.main.itmanagement.Entities;

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
    }

    // Getters and setters
}
