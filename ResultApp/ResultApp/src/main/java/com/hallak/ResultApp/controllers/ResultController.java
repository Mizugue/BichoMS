package com.hallak.ResultApp.controllers;

import com.hallak.ResultApp.dtos.ResultDTO;
import com.hallak.ResultApp.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping
    public ResponseEntity<ResultDTO> getNewResult(){
        return new ResponseEntity<>(resultService.getNewResult(), HttpStatus.CREATED);
    }
}
