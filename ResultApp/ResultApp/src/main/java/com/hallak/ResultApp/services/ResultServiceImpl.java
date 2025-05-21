package com.hallak.ResultApp.services;

import com.hallak.ResultApp.dtos.GameInterServiceDTO;
import com.hallak.ResultApp.dtos.ResultDTO;
import com.hallak.ResultApp.models.Result;
import com.hallak.ResultApp.repositories.ResultRepository;
import com.hallak.ResultApp.util.ResultUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{

    private final ModelMapper modelMapper;
    private final ResultRepository resultRepository;
    private final GameFeignClient gameFeignClient;

    @Autowired
    public ResultServiceImpl(ModelMapper modelMapper, ResultRepository resultRepository, GameFeignClient gameFeignClient){
        this.modelMapper = modelMapper;
        this.resultRepository = resultRepository;
        this.gameFeignClient = gameFeignClient;
    }



    @Override
    public List<ResultDTO> getNewResults() {
        List<GameInterServiceDTO> gamesExpired = gameFeignClient.findAllGamesExpired();
        List<Result> results = new ArrayList<>();
        List<ResultDTO> resultDTOS = new ArrayList<>();

        for (GameInterServiceDTO game : gamesExpired) {
            Result result = modelMapper.map(ResultUtils.getNewResult(), Result.class);
            result.setGameId(game.getId());
            results.add(result);
        }

        resultRepository.saveAll(results);


        for (int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            ResultDTO dto = modelMapper.map(result, ResultDTO.class);
            dto.setGame(gamesExpired.get(i));
            resultDTOS.add(dto);
        }

        return resultDTOS;
    }

    @Override
    public List<ResultDTO> getResults() {
        List<ResultDTO> resultDTOS = resultRepository.findAll().stream().map(x -> modelMapper.map(x, ResultDTO.class)).toList();
        for (ResultDTO result : resultDTOS) {
            result.setGame(gameFeignClient.findGameById(result.getGame().getId()));
        }
        return resultDTOS;




    }

    @Override
    public ResultDTO getResultsByGameId(Long id) {
        ResultDTO resultDTO = modelMapper.map(resultRepository.findByGameId(id), ResultDTO.class);
        resultDTO.setGame(gameFeignClient.findGameById(id));
        return resultDTO;



    }


}

