package com.main.itmanagement.DTO;
import java.util.Date;
import java.util.List;

public class FactureDTO {
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

    // Getters and Setters
    public String getNumero() { return numero; }
    public Date getDate() { return date; }
    public double getMontantTotal() { return montantTotal; }
    public List<ReparationDTO> getReparations() { return reparations; }
}
