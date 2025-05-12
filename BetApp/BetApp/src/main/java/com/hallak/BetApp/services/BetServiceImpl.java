package com.hallak.BetApp.services;

import com.hallak.BetApp.dtos.bet.BetDTO;
import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;
import com.hallak.BetApp.models.Bet;
import com.hallak.BetApp.repositories.BetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BetServiceImpl implements BetService{

    private final BetRepository betRepository;
    private final ModelMapper modelMapper;
    private final AuthenticatedUserService authenticatedUserService;

    public BetServiceImpl(BetRepository betRepository, ModelMapper modelMapper, AuthenticatedUserService authenticatedUserService){
        this.betRepository = betRepository;
        this.modelMapper = modelMapper;
        this.authenticatedUserService = authenticatedUserService;
    }

    @Override
    public BetReturnOfNewDTO newBet(BetNewDTO betDTO) {
        Bet bet = modelMapper.map(betDTO, Bet.class);
        bet.setDate(LocalDateTime.now());
        bet.setUser(authenticatedUserService.authenticated());
        return modelMapper.map(betRepository.save(bet), BetReturnOfNewDTO.class);




    }
}
