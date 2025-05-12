package com.hallak.GameApp.repositories;

import com.hallak.GameApp.models.Game;
import com.hallak.GameApp.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByHouseId(Long houseId);

}
