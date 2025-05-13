package com.hallak.GameApp.services;


import com.hallak.GameApp.dtos.Game.GameDTO;
import com.hallak.GameApp.dtos.Game.GameInterServiceDTO;
import com.hallak.GameApp.dtos.Game.GameMakeDTO;

import java.util.List;


public interface GameService {

    GameDTO newGame(GameMakeDTO dto);
    List<GameDTO> findAllMy();
    List<GameInterServiceDTO> findAll();


}
