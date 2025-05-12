package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.GameDTO;
import com.hallak.GameApp.dtos.GameMakeDTO;
import com.hallak.GameApp.models.Game;
import com.hallak.GameApp.models.House;
import com.hallak.GameApp.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<GameDTO> findAll() {
        return gameRepository.findByHouseId(authenticatedHouseService.authenticated().getId())
                .stream().map(x -> modelMapper.map(x, GameDTO.class)).toList();
    }
}
