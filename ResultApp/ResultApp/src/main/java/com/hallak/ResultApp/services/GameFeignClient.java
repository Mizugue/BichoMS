package com.hallak.ResultApp.services;


import com.hallak.ResultApp.dtos.GameInterServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "jogoapp-service")
public interface GameFeignClient {

    @GetMapping(value = "/data-ex")
    List<GameInterServiceDTO> findAllGamesExpired();

    @GetMapping(value = "/{id}")
    GameInterServiceDTO findGameById(@PathVariable Long id);


}
