package com.hallak.BetApp.services;


import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;
import com.hallak.BetApp.dtos.external.GameInterServiceDTO;
import com.hallak.BetApp.models.Bet;
import com.hallak.BetApp.repositories.BetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class BetServiceImpl implements BetService{

    private final BetRepository betRepository;
    private final ModelMapper modelMapper;
    private final AuthenticatedUserService authenticatedUserService;
    private final GameFeignClient gameFeignClient;

    @Autowired
    public BetServiceImpl(BetRepository betRepository, ModelMapper modelMapper, AuthenticatedUserService authenticatedUserService, GameFeignClient gameFeignClient){
        this.betRepository = betRepository;
        this.modelMapper = modelMapper;
        this.authenticatedUserService = authenticatedUserService;
        this.gameFeignClient = gameFeignClient;
    }

    @Override
    public BetReturnOfNewDTO newBet(BetNewDTO betDTO) {
        GameInterServiceDTO gameInterServiceDTO = gameFeignClient.findGameById(betDTO.getGameId());
        if (gameInterServiceDTO == null || gameInterServiceDTO.getCaptureDate().isBefore(LocalDateTime.now())) {
            throw new DataAccessResourceFailureException("GameId " + betDTO.getGameId() + " is invalid, expired, or not found.");
        }

        Bet bet = new Bet();
        bet.setAmount(betDTO.getAmount());
        bet.setType(betDTO.getType());
        bet.setValues(betDTO.getValues());
        bet.setDate(LocalDateTime.now());
        bet.setUser(authenticatedUserService.authenticated());
        bet.setGameId(betDTO.getGameId());

        BetReturnOfNewDTO betThatReturn = modelMapper.map(betRepository.save(bet), BetReturnOfNewDTO.class);
        betThatReturn.setGame(gameFeignClient.findGameById(betDTO.getGameId()));

        return betThatReturn;
    }



    @Override
    public List<GameInterServiceDTO> findAllGames() {
        return gameFeignClient.findAllGames();
    }

    @Override
    public GameInterServiceDTO findGameById(Long id) {
        return gameFeignClient.findGameById(id);
    }

    @Override
    public BetReturnOfNewDTO findById(Long id) {
        Optional<BetReturnOfNewDTO> betDTO = betRepository.findById(id).map(x -> modelMapper.map(x, BetReturnOfNewDTO.class));
        if (betDTO.isPresent()){
            betDTO.get().setGame(gameFeignClient.findGameById(betDTO.get().getGame().getId()));
            return betDTO.get();
        } else {
            throw new DataAccessResourceFailureException("BetId " + id + " is invalid or not found.");
        }




    }
}
