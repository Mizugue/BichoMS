package com.hallak.BetApp.services;


import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;
import com.hallak.BetApp.dtos.external.GameInterServiceDTO;

import java.util.List;
import java.util.Optional;

public interface BetService {
    BetReturnOfNewDTO newBet(BetNewDTO betDTO);
    List<GameInterServiceDTO> findAllGames();
    GameInterServiceDTO findGameById(Long id);
    BetReturnOfNewDTO findById(Long id);
}
