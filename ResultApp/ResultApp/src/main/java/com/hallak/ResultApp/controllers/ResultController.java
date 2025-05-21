package com.hallak.ResultApp.controllers;

import com.hallak.ResultApp.dtos.ResultDTO;
import com.hallak.ResultApp.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping
    public ResponseEntity<List<ResultDTO>> getNewResults(){
        return new ResponseEntity<>(resultService.getNewResults(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResultDTO>> getResults(){
        return new ResponseEntity<>(resultService.getResults(), HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<ResultDTO> getResultsByGameId(@PathVariable Long id){
        return new ResponseEntity<>(resultService.getResultsByGameId(id), HttpStatus.OK);
    }




}
