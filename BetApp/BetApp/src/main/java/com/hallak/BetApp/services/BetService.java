package com.hallak.BetApp.services;

import com.hallak.BetApp.dtos.bet.BetDTO;
import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;
import com.hallak.BetApp.dtos.external.GameInterServiceDTO;

import java.util.List;

public interface BetService {
    BetReturnOfNewDTO newBet(BetNewDTO betDTO);
    List<GameInterServiceDTO> findAllGames();
}
