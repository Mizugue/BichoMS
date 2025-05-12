package com.hallak.ResultApp.services;

import com.hallak.ResultApp.dtos.ResultDTO;
import com.hallak.ResultApp.models.Result;
import com.hallak.ResultApp.repositories.ResultRepository;
import com.hallak.ResultApp.util.ResultUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
