package com.main.itmanagement.Controller;

import com.main.itmanagement.Entities.Reparation;
import com.main.itmanagement.DTO.ReparationDTO;
import com.main.itmanagement.Service.ReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/CRUD/reparation")

public class ReparationController {

    @Autowired
    private ReparationService reparationService;

    // Create a new Reparation
    @PostMapping
    public ResponseEntity<Reparation> createReparation(@RequestBody Reparation reparation) {
        try {
            System.out.println(reparation.toString());
            // Save the Reparation and return the saved entity
            Reparation savedReparation = reparationService.createReparation(reparation);
            return ResponseEntity.ok(savedReparation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // Handle any exception and return 400 Bad Request
        }
    }

    // Get all Reparations
    @GetMapping
    public List<ReparationDTO> getAllReparations() {
        return reparationService.getAllReparations();
    }


    // Get Reparation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reparation> getReparationById(@PathVariable int id) {
        Reparation reparation = reparationService.getReparationById(id);
        if (reparation != null) {
            return ResponseEntity.ok(reparation);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }

    // Update a Reparation
    @PutMapping("/{id}")
    public ResponseEntity<Reparation> updateReparation(@PathVariable int id, @RequestBody Reparation reparation) {
        Reparation existingReparation = reparationService.getReparationById(id);
        if (existingReparation != null) {
            // Update fields from the Reparation entity
            existingReparation.setDateRep(reparation.getDateRep());
            existingReparation.setDescription(reparation.getDescription());
            existingReparation.setTarifHMO(reparation.getTarifHMO());
            existingReparation.setTempsMO(reparation.getTempsMO());

            // Save the updated Reparation and return the updated entity
            Reparation updatedReparation = reparationService.createReparation(existingReparation);
            return ResponseEntity.ok(updatedReparation);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }

    // Delete a Reparation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReparation(@PathVariable int id) {
        Reparation existingReparation = reparationService.getReparationById(id);
        if (existingReparation != null) {
            reparationService.deleteReparation(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }
}
