package com.main.itmanagement.Repository;

import com.main.itmanagement.Entities.PieceRechange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRechangeRepository extends JpaRepository<PieceRechange, Integer> {
}
