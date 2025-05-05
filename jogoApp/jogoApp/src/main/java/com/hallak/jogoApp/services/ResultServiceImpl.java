package com.hallak.jogoApp.services;

import com.hallak.jogoApp.dtos.ResultDTO;
import com.hallak.jogoApp.models.Result;
import com.hallak.jogoApp.repositories.ResultRepository;
import com.hallak.jogoApp.utils.ResultUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ResultServiceImpl implements ResultService{

    private final ModelMapper modelMapper;
    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ModelMapper modelMapper, ResultRepository resultRepository){
        this.modelMapper = modelMapper;
        this.resultRepository = resultRepository;
    }


    @Override
    public ResultDTO getNewResult() {
        return modelMapper.map(resultRepository.save(modelMapper.map(ResultUtils.getNewResult(), Result.class)), ResultDTO.class);

    }
}
