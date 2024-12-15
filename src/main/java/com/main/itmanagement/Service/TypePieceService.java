package com.main.itmanagement.Service;

import com.main.itmanagement.Entities.TypePiece;
import com.main.itmanagement.Repository.TypePieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypePieceService {

    @Autowired
    private TypePieceRepository typePieceRepository;

    // Get all TypePieces
    public List<TypePiece> getAllTypePieces() {
        return typePieceRepository.findAll();
    }

    // Get a single TypePiece by ID
    public TypePiece getTypePieceById(int id) {
        return typePieceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypePiece not found with ID: " + id));
    }

    // Save a new TypePiece or update an existing one
    public TypePiece saveTypePiece(TypePiece typePiece) {
        return typePieceRepository.save(typePiece);
    }

    // Delete a TypePiece by ID
    public void deleteTypePiece(int id) {
        Optional<TypePiece> typePiece = typePieceRepository.findById(id);
        if (typePiece.isPresent()) {
            typePieceRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot delete, TypePiece not found with ID: " + id);
        }
    }
}
