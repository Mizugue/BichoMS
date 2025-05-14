package com.hallak.GameApp.services;


import com.hallak.GameApp.dtos.game.GameDTO;
import com.hallak.GameApp.dtos.game.GameInterServiceDTO;
import com.hallak.GameApp.dtos.game.GameMakeDTO;

import java.util.List;


public interface GameService {

    GameDTO newGame(GameMakeDTO dto);
    List<GameDTO> findAllMy();
    List<GameInterServiceDTO> findAll();
    GameInterServiceDTO findById(Long id);


}
