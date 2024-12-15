package com.main.itmanagement.Controller;

import com.main.itmanagement.Entities.TypePiece;
import com.main.itmanagement.Service.TypePieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/CRUD/typePieces")
//@CrossOrigin(origins = "*") // Allow cross-origin requests for frontend
public class TypePieceController {

    @Autowired
    private TypePieceService typePieceService;

    // Get all TypePieces
    @GetMapping
    public List<TypePiece> getAllTypePieces() {
        return typePieceService.getAllTypePieces();
    }

    // Get a TypePiece by ID
    @GetMapping("/{id}")
    public ResponseEntity<TypePiece> getTypePieceById(@PathVariable int id) {
        TypePiece typePiece = typePieceService.getTypePieceById(id);
        return ResponseEntity.ok(typePiece);
    }

    // Create a new TypePiece
    @PostMapping
    public ResponseEntity<TypePiece> createTypePiece(@RequestBody TypePiece typePiece) {
        TypePiece newTypePiece = typePieceService.saveTypePiece(typePiece);
        return ResponseEntity.ok(newTypePiece);
    }

    // Update an existing TypePiece
    @PutMapping("/{id}")
    public ResponseEntity<TypePiece> updateTypePiece(@PathVariable int id, @RequestBody TypePiece typePiece) {
        typePiece.setIdTypePiece(id); // Ensure consistency of the ID
        TypePiece updatedTypePiece = typePieceService.saveTypePiece(typePiece);
        return ResponseEntity.ok(updatedTypePiece);
    }

    // Delete a TypePiece
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTypePiece(@PathVariable int id) {
        typePieceService.deleteTypePiece(id);
        return ResponseEntity.ok("TypePiece with ID " + id + " deleted successfully.");
    }
}
