package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.game.GameDTO;
import com.hallak.GameApp.dtos.game.GameInterServiceDTO;
import com.hallak.GameApp.dtos.game.GameMakeDTO;
import com.hallak.GameApp.dtos.house.HouseFromGISDTO;
import com.hallak.GameApp.models.Game;
import com.hallak.GameApp.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
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

}
