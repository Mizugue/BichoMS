package com.hallak.BetApp.services;


import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;
import com.hallak.BetApp.dtos.bet.BetToFindAllDTO;
import com.hallak.BetApp.dtos.external.GameInterServiceDTO;
import com.hallak.BetApp.dtos.external.GameToFindAllDTO;
import com.hallak.BetApp.exceptions.exception.InvalidArgumentException;
import com.hallak.BetApp.models.Bet;
import com.hallak.BetApp.repositories.BetRepository;
import com.hallak.BetApp.util.BetValuesValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BetServiceImpl implements BetService{

    private final BetRepository betRepository;
    private final ModelMapper modelMapper;
    private final AuthenticatedUserService authenticatedUserService;
    private final GameFeignClient gameFeignClient;
    private final BetValuesValidator betValuesValidator;

    @Autowired
    public BetServiceImpl(BetRepository betRepository, ModelMapper modelMapper, AuthenticatedUserService authenticatedUserService, GameFeignClient gameFeignClient, BetValuesValidator betValuesValidator){
        this.betRepository = betRepository;
        this.modelMapper = modelMapper;
        this.authenticatedUserService = authenticatedUserService;
        this.gameFeignClient = gameFeignClient;
        this.betValuesValidator = betValuesValidator;
    }

    @Override
    public BetReturnOfNewDTO newBet(BetNewDTO betDTO) {
        GameInterServiceDTO gameInterServiceDTO = gameFeignClient.findGameById(betDTO.getGameId());
        if (gameInterServiceDTO == null || gameInterServiceDTO.getCaptureDate().isBefore(LocalDateTime.now())) {
            throw new InvalidArgumentException("GameId " + betDTO.getGameId() + " is invalid, expired, or not found.");
        }


        Bet bet = new Bet();
        bet.setAmount(betDTO.getAmount());
        bet.setType(betValuesValidator.validateBetType(betDTO));
        bet.setValues(betValuesValidator.validateAndFormatValues(betDTO));
        bet.setDate(LocalDateTime.now());
        bet.setUser(authenticatedUserService.authenticated());
        bet.setGameId(betDTO.getGameId());

        BetReturnOfNewDTO betThatReturn = modelMapper.map(betRepository.save(bet), BetReturnOfNewDTO.class);
        betThatReturn.setGame(gameFeignClient.findGameById(betDTO.getGameId()));

        return betThatReturn;
    }



    @Override
    public BetReturnOfNewDTO findById(Long id) {
        Optional<BetReturnOfNewDTO> betDTO = betRepository.findById(id).map(x -> modelMapper.map(x, BetReturnOfNewDTO.class));
        if (betDTO.isPresent()){
            betDTO.get().setGame(gameFeignClient.findGameById(betDTO.get().getGame().getId()));
            return betDTO.get();
        } else {
            throw new InvalidArgumentException("BetId " + id + " is invalid or not found.");
        }




    }

    @Override
    public List<BetToFindAllDTO> findAll() {
        List<BetToFindAllDTO> bets = betRepository.findAll().stream().map(x -> modelMapper.map(x, BetToFindAllDTO.class)).toList();

        for (BetToFindAllDTO bet : bets){
            GameInterServiceDTO game = gameFeignClient.findGameById(bet.getGame().getId());
            bet.getGame().setName(game.getName());
            bet.getGame().setCaptureDate(game.getCaptureDate());
            bet.getGame().setCreationDate(game.getCreationDate());
            bet.getGame().setHouse(bet.getGame().getHouse());
            bet.setUser(bet.getUser());

        }

        return bets;

    }

    @Override
    public List<BetToFindAllDTO> findAllByUsername(String username) {
        return betRepository.findByUserUsername(username).stream().map(x -> modelMapper.map(x, BetToFindAllDTO.class)).toList();


    }
}
