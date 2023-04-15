package com.week3.week3hw.repository;

import com.week3.week3hw.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findById(Long id);
}
