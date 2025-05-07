package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.GameDTO;
import com.hallak.GameApp.dtos.GameMakeDTO;
import com.hallak.GameApp.models.Game;
import com.hallak.GameApp.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class GameServiceImpl implements GameService {

    private final ModelMapper modelMapper;
    private final GameRepository gameRepository;

    public GameServiceImpl(ModelMapper modelMapper, GameRepository gameRepository){
        this.modelMapper = modelMapper;
        this.gameRepository = gameRepository;
    }

    @Override
    public GameDTO newGame(GameMakeDTO dto) {
        Game game = modelMapper.map(dto, Game.class);
        game.setCreationDate(LocalDateTime.now());
        game.setStatus(true);
        return modelMapper.map(gameRepository.save(game), GameDTO.class);
    }

    @Override
    public Page<GameDTO> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable).map(x -> modelMapper.map(x, GameDTO.class));
    }
}
