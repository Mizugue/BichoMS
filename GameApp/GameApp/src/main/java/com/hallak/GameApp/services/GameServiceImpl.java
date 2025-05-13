package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.Game.GameDTO;
import com.hallak.GameApp.dtos.Game.GameInterServiceDTO;
import com.hallak.GameApp.dtos.Game.GameMakeDTO;
import com.hallak.GameApp.dtos.House.HouseFromGISDTO;
import com.hallak.GameApp.models.Game;
import com.hallak.GameApp.repositories.GameRepository;
import com.hallak.GameApp.repositories.HouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final ModelMapper modelMapper;
    private final GameRepository gameRepository;
    private final AuthenticatedHouseService authenticatedHouseService;
    private final HouseRepository houseRepository;

    public GameServiceImpl(ModelMapper modelMapper, GameRepository gameRepository, AuthenticatedHouseService authenticatedHouseService, HouseRepository houseRepository){
        this.modelMapper = modelMapper;
        this.gameRepository = gameRepository;
        this.authenticatedHouseService = authenticatedHouseService;
        this.houseRepository = houseRepository;
    }

    @Override
    public GameDTO newGame(GameMakeDTO dto) {
        Game game = modelMapper.map(dto, Game.class);
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

}
