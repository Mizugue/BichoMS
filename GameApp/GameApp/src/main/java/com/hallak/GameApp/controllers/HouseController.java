package com.hallak.GameApp.controllers;

import com.hallak.GameApp.dtos.game.GameDTO;
import com.hallak.GameApp.dtos.house.*;
import com.hallak.GameApp.models.BetType;
import com.hallak.GameApp.services.GameService;
import com.hallak.GameApp.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private GameService gameService;

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping(value = "/me")
    public ResponseEntity<HouseDTO> getMe(){
        return new ResponseEntity<>(houseService.getMe(), HttpStatus.OK);
    }


    @PostMapping(value = "/register")
    public ResponseEntity<HouseReturnOfRegisterDTO> saveHouse(@RequestBody HouseRegisterDTO houseDTO){
        return new ResponseEntity<>(houseService.saveHouse(houseDTO), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping(value = "/odds")
    public ResponseEntity<HouseOddsDTO> newOdds(@RequestBody HouseOddsDTO houseDTO){
        return new ResponseEntity<>(houseService.newOdds(houseDTO), HttpStatus.CREATED);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @GetMapping(value = "/games")
    public ResponseEntity<List<GameDTO>> findAllMy(){
        return new ResponseEntity<>(gameService.findAllMy(), HttpStatus.OK);
    }

    @GetMapping(value = "/calculate-amount")
    public ResponseEntity<Double> calculateAmount(@RequestParam String username, @RequestParam BetType betType, @RequestParam Double amount){
        return new ResponseEntity<>(houseService.calculateAmount(username, betType, amount), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HouseFromGISDTO>> findAll(){
        return new ResponseEntity<>(houseService.findAll(), HttpStatus.OK);
    }







}
