package com.main.itmanagement.Entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Reparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReparation;

    private Date dateRep;
    private String description;
    private double tarifHMO;
    private int tempsMO;

    @ManyToOne
    @JoinColumn(name = "demande_reparation_id")
    @JsonBackReference
    private DemandeReparation demandeReparation;

    @ManyToOne
    @JoinColumn(name = "idPiece") // Foreign key linking to PieceRechange
    private PieceRechange piece;  // Represents the part used in the repair

    @ManyToOne
    @JoinColumn(name = "id_facture")
    private Facture facture;

}
