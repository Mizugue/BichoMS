package com.hallak.GameApp.controllers;

import com.hallak.GameApp.dtos.GameDTO;
import com.hallak.GameApp.dtos.GameMakeDTO;
import com.hallak.GameApp.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll(){
        return new ResponseEntity<>(gameService.findAll(), HttpStatus.OK);
    }





}
