package com.main.itmanagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Appareil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAppareil;  // Changed from int to Long

    @NotNull
    @Size(min = 2, max = 50)
    private String marque;

    @NotNull
    @Size(min = 2, max = 50)
    private String modele;

    @NotNull
    @Size(min = 5, max = 50)
    private String numSerie;

}
