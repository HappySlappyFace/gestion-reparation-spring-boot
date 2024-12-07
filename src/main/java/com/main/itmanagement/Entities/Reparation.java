package com.main.itmanagement.Entities;

import jakarta.persistence.*;
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
    @JoinColumn(name = "demande_reparation_id")  // Foreign key linking to DemandeReparation
    private DemandeReparation demandeReparation;

}
