package com.main.itmanagement.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFacture;

    private Date date;
    private double montantTotal;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "idReparation")
    private Reparation reparation;

}
