package com.hallak.BetApp.services;

import com.hallak.BetApp.dtos.external.GameInterServiceDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "game-service",
url = "http://localhost:1000/")
public interface GameFeignClient {

    @GetMapping
    List<GameInterServiceDTO> findAllGames();

    @GetMapping(value = "/{id}")
    GameInterServiceDTO findGameById(@PathVariable Long id);






}
