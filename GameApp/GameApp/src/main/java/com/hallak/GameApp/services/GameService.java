package com.hallak.GameApp.services;


import com.hallak.GameApp.dtos.GameDTO;
import com.hallak.GameApp.dtos.GameMakeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GameService {

    GameDTO newGame(GameMakeDTO dto);
    Page<GameDTO> findAll(Pageable pageable);


}
