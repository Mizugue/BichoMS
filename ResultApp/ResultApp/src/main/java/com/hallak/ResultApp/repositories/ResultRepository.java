package com.hallak.ResultApp.repositories;

import com.hallak.ResultApp.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    Optional<Result> findByGameId(Long gameId);


}
