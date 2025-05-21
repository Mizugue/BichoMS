package com.hallak.ResultApp.services;

import com.hallak.ResultApp.dtos.ResultDTO;

import java.util.List;

public interface ResultService {
    List<ResultDTO> getNewResults();
    List<ResultDTO> getResults();
    ResultDTO getResultsByGameId(Long id);
}
