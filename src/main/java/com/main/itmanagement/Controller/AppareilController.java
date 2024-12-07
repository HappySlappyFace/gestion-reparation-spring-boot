package com.main.itmanagement.Controller;

import com.main.itmanagement.Entities.Appareil;
import com.main.itmanagement.Service.AppareilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/CRUD/appareil")
public class AppareilController {

    @Autowired
    private AppareilService appareilService;

    // Create a new Appareil
    @PostMapping
    public ResponseEntity<Appareil> createAppareil(@Validated @RequestBody Appareil appareil) {
        Appareil savedAppareil = appareilService.addAppareil(appareil);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppareil);
    }

    // Get all Appareils
    @GetMapping
    public ResponseEntity<List<Appareil>> getAllAppareils() {
        List<Appareil> appareils = appareilService.getAllAppareils();
        return ResponseEntity.ok(appareils);
    }

    // Get Appareil by ID
    @GetMapping("/{id}")
    public ResponseEntity<Appareil> getAppareilById(@PathVariable Long id) {
        Appareil appareil = appareilService.getAppareilById(id);
        return ResponseEntity.ok(appareil);
    }

    // Update Appareil
    @PutMapping("/{id}")
    public ResponseEntity<Appareil> updateAppareil(@PathVariable Long id, @Validated @RequestBody Appareil appareilDetails) {
        Appareil updatedAppareil = appareilService.updateAppareil(id, appareilDetails);
        return ResponseEntity.ok(updatedAppareil);
    }

    // Delete Appareil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppareil(@PathVariable Long id) {
        appareilService.deleteAppareil(id);
        return ResponseEntity.noContent().build();
    }
}
