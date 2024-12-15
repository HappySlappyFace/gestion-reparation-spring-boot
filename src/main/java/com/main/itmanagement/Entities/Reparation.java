package com.main.itmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
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
    @JsonBackReference
    private DemandeReparation demandeReparation;

}
