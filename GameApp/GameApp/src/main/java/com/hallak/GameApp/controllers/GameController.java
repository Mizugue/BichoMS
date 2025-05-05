package com.hallak.GameApp.controllers;

import com.hallak.GameApp.dtos.GameDTO;
import com.hallak.GameApp.dtos.GameMakeDTO;
import com.hallak.GameApp.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class GameController {

    @Autowired
    private GameService gameService;


    @PostMapping
    public ResponseEntity<GameDTO> newGame(@RequestBody GameMakeDTO dto){
        return new ResponseEntity<>(gameService.newGame(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<GameDTO>> findAll(Pageable pageable){
        return new ResponseEntity<>(gameService.findAll(pageable), HttpStatus.OK);
    }





}
