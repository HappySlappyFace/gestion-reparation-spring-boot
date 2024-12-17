package com.main.itmanagement.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FactureDTO {
    private int idFacture; // Add this field
    private String numero;
    private Date date;
    private double montantTotal;
    private List<ReparationDTO> reparations;

    public FactureDTO(String numero, Date date, double montantTotal, List<ReparationDTO> reparations) {
        this.numero = numero;
        this.date = date;
        this.montantTotal = montantTotal;
        this.reparations = reparations;
    }
}
