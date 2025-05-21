package com.hallak.GameApp.repositories;

import com.hallak.GameApp.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByHouseId(Long houseId);

    @Query("SELECT g FROM Game g JOIN FETCH g.house")
    List<Game> findAllWithHouse();

    List<Game> findByCaptureDateLessThanEqual(LocalDateTime now);

    List<Game> findByCaptureDateAfter(LocalDateTime now);




}
