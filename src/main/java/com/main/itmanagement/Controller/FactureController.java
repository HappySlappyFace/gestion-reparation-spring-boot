package com.main.itmanagement.Controller;

import com.main.itmanagement.DTO.FactureDTO;
import com.main.itmanagement.Entities.Facture;
import com.main.itmanagement.Service.FactureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/CRUD/factures")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    // Generate facture for all reparations of a Repair Request
    @PostMapping("/generate/{idDemandeReparation}")
    public ResponseEntity<FactureDTO> generateFactureForRepairRequest(@PathVariable int idDemandeReparation) {
        FactureDTO factureDTO = factureService.generateFactureForRepairRequest(idDemandeReparation);
        return ResponseEntity.ok(factureDTO); // Return the FactureDTO to the client
    }

}

