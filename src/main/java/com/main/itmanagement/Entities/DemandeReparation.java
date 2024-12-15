package com.main.itmanagement.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class DemandeReparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDemande;

    private Date dateDepotAppareil;
    private Date datePrevueRep;
    private String etat;
    private String symptomesPanne;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idAppareil")
    private Appareil appareil;

    @OneToMany(mappedBy = "demandeReparation")
    @JsonManagedReference
    private List<Reparation> reparations;


}
