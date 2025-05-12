package com.hallak.GameApp.services;


import com.hallak.GameApp.dtos.GameDTO;
import com.hallak.GameApp.dtos.GameMakeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface GameService {

    GameDTO newGame(GameMakeDTO dto);
    List<GameDTO> findAll();


}
