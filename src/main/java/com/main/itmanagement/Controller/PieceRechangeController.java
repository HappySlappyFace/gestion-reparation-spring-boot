package com.main.itmanagement.Controller;

import com.main.itmanagement.Entities.PieceRechange;
import com.main.itmanagement.Service.PieceRechangeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/CRUD/pieces")
public class PieceRechangeController {

    private final PieceRechangeService pieceRechangeService;

    public PieceRechangeController(PieceRechangeService pieceRechangeService) {
        this.pieceRechangeService = pieceRechangeService;
    }

    @GetMapping
    public List<PieceRechange> getAllPieces() {
        return pieceRechangeService.getAllPieces();
    }

    @GetMapping("/{id}")
    public PieceRechange getPieceById(@PathVariable int id) {
        return pieceRechangeService.getPieceById(id);
    }

    @PostMapping
    public PieceRechange addPiece(@RequestBody PieceRechange pieceRechange) {
        System.out.println("Hey im in a Post Mapping!");
        return pieceRechangeService.addOrUpdatePiece(pieceRechange);
    }

    @PutMapping("/{id}")
    public PieceRechange updatePiece(@PathVariable int id, @RequestBody PieceRechange pieceRechange) {
        pieceRechange.setIdPiece(id);
        return pieceRechangeService.addOrUpdatePiece(pieceRechange);
    }

    @DeleteMapping("/{id}")
    public void deletePiece(@PathVariable int id) {
        pieceRechangeService.deletePiece(id);
    }
}
