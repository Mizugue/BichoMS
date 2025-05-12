package com.hallak.GameApp.repositories;

import com.hallak.GameApp.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    Optional<House> findByUsername(String username);
}
