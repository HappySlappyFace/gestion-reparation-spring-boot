package com.main.itmanagement.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TypePiece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypePiece;

    private double tarifH;
    private String type;

}

