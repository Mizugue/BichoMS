package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.game.GameDTO;
import com.hallak.GameApp.dtos.game.GameInterServiceDTO;
import com.hallak.GameApp.dtos.game.GameMakeDTO;
import com.hallak.GameApp.dtos.house.HouseFromGISDTO;
import com.hallak.GameApp.exceptions.exception.InvalidArgumentException;
import com.hallak.GameApp.models.Game;
import com.hallak.GameApp.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final ModelMapper modelMapper;
    private final GameRepository gameRepository;
    private final AuthenticatedHouseService authenticatedHouseService;


    public GameServiceImpl(ModelMapper modelMapper, GameRepository gameRepository, AuthenticatedHouseService authenticatedHouseService){
        this.modelMapper = modelMapper;
        this.gameRepository = gameRepository;
        this.authenticatedHouseService = authenticatedHouseService;

    }

    @Override
    public GameDTO newGame(GameMakeDTO dto) {
        Game game = modelMapper.map(dto, Game.class);
        if (dto.getCaptureDate().isBefore(LocalDateTime.now())){
             throw new InvalidArgumentException("The CaptureDate shall be in the future! ");
        }
        game.setCreationDate(LocalDateTime.now());
        game.setStatus(true);
        game.setHouse(authenticatedHouseService.authenticated());
        return modelMapper.map(gameRepository.save(game), GameDTO.class);
    }

    @Override
    public List<GameDTO> findAllMy() {
        return gameRepository.findByHouseId(authenticatedHouseService.authenticated().getId())
                .stream().map(x -> modelMapper.map(x, GameDTO.class)).toList();
    }


    @Override
    public List<GameInterServiceDTO> findAll() {
        List<Game> gamesWithHouse = gameRepository.findAllWithHouse();
        return gamesWithHouse.stream()
            .map(game -> {
                GameInterServiceDTO dto = modelMapper.map(game, GameInterServiceDTO.class);
                dto.setHouse(modelMapper.map(game.getHouse(), HouseFromGISDTO.class));
                return dto;
            }).toList();
    }

    @Override
    public GameInterServiceDTO findById(Long id) {
        return modelMapper.map(gameRepository.findById(id), GameInterServiceDTO.class);
    }

    @Override
    public List<GameInterServiceDTO> findAllExpiredGames() {
        List<Game> gamesExpired = gameRepository.findByCaptureDateLessThanEqual(LocalDateTime.now());
        List<Game> gamesThatNowAreExpired = new ArrayList<>();

        for (Game game : gamesExpired){
            game.setStatus(false);
            gamesThatNowAreExpired.add(game);
        }
        gameRepository.saveAll(gamesThatNowAreExpired);

        return gamesExpired.stream().map(x -> modelMapper.map(x, GameInterServiceDTO.class)).toList();
    }

    @Override
    public List<GameInterServiceDTO> findAllValidGames() {
        return gameRepository.findByCaptureDateAfter(LocalDateTime.now()).stream().map(x -> modelMapper.map(x, GameInterServiceDTO.class)).toList();
    }

}
