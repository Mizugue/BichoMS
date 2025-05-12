package com.hallak.BetApp.services;

import com.hallak.BetApp.dtos.bet.BetDTO;
import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;

public interface BetService {
    BetReturnOfNewDTO newBet(BetNewDTO betDTO);
}
