package com.main.itmanagement.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PieceRechange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPiece;

    private String code;
    private String nom;
    private double prixAchat;
    private double prixHT;
    private double prixTTC;

    @ManyToOne
    @JoinColumn(name = "idTypePiece")
    private TypePiece typePiece;

}
