package com.main.itmanagement.Service;

import com.main.itmanagement.Entities.PieceRechange;
import com.main.itmanagement.Repository.PieceRechangeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceRechangeService {

    private final PieceRechangeRepository pieceRechangeRepository;

    public PieceRechangeService(PieceRechangeRepository pieceRechangeRepository) {
        this.pieceRechangeRepository = pieceRechangeRepository;
    }

    public List<PieceRechange> getAllPieces() {
        return pieceRechangeRepository.findAll();
    }

    public PieceRechange getPieceById(int id) {
        return pieceRechangeRepository.findById(id).orElse(null);
    }

    public PieceRechange addOrUpdatePiece(PieceRechange pieceRechange) {
        return pieceRechangeRepository.save(pieceRechange);
    }

    public void deletePiece(int id) {
        pieceRechangeRepository.deleteById(id);
    }
}
