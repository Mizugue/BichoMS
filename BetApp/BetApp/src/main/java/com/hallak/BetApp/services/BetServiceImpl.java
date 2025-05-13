package com.hallak.BetApp.services;

import com.hallak.BetApp.dtos.bet.BetDTO;
import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;
import com.hallak.BetApp.dtos.external.GameInterServiceDTO;
import com.hallak.BetApp.models.Bet;
import com.hallak.BetApp.repositories.BetRepository;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BetServiceImpl implements BetService{

    private final BetRepository betRepository;
    private final ModelMapper modelMapper;
    private final AuthenticatedUserService authenticatedUserService;
    private final GameFeignClient gameFeignClient;

    public BetServiceImpl(BetRepository betRepository, ModelMapper modelMapper, AuthenticatedUserService authenticatedUserService, GameFeignClient gameFeignClient){
        this.betRepository = betRepository;
        this.modelMapper = modelMapper;
        this.authenticatedUserService = authenticatedUserService;
        this.gameFeignClient = gameFeignClient;
    }

    @Override
    public BetReturnOfNewDTO newBet(BetNewDTO betDTO) {
        Bet bet = modelMapper.map(betDTO, Bet.class);
        bet.setDate(LocalDateTime.now());
        bet.setUser(authenticatedUserService.authenticated());
        // Aqui falta a verificacao com outro metodo da interface!
        bet.setGameId(betDTO.getGameId());
        return modelMapper.map(betRepository.save(bet), BetReturnOfNewDTO.class);
    }


    @Override
    public List<GameInterServiceDTO> findAllGames() {
        return gameFeignClient.findAllGames();
    }
}
