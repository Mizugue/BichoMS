package com.hallak.GameApp.controllers;

import com.hallak.GameApp.dtos.game.GameDTO;
import com.hallak.GameApp.dtos.game.GameInterServiceDTO;
import com.hallak.GameApp.dtos.game.GameMakeDTO;
import com.hallak.GameApp.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GameController {

    @Autowired
    private GameService gameService;


    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping
    public ResponseEntity<GameDTO> newGame(@RequestBody GameMakeDTO dto){
        return new ResponseEntity<>(gameService.newGame(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GameInterServiceDTO>> findAll(){
        return new ResponseEntity<>(gameService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameInterServiceDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(gameService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/data-ex")
    public ResponseEntity<List<GameInterServiceDTO>> findAllExpiredGames(){
        return new ResponseEntity<>(gameService.findAllExpiredGames(), HttpStatus.OK);
    }





}
