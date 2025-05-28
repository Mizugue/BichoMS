package com.hallak.BetApp.controllers;


import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;
import com.hallak.BetApp.dtos.bet.BetToFindAllDTO;
import com.hallak.BetApp.dtos.external.GameInterServiceDTO;
import com.hallak.BetApp.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BetController {

    @Autowired
    private BetService betService;

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping
    public ResponseEntity<BetReturnOfNewDTO> newBet(@RequestBody BetNewDTO betDTO){
        return new ResponseEntity<>(betService.newBet(betDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/bet/{id}")
    public ResponseEntity<BetReturnOfNewDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(betService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/api/bet")
    public ResponseEntity<List<BetToFindAllDTO>> findAll(){
        return new ResponseEntity<>(betService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/bet/user/{username}")
    public ResponseEntity<List<BetToFindAllDTO>> findAllByUsername(@PathVariable String username){
        return new ResponseEntity<>(betService.findAllByUsername(username), HttpStatus.OK);
    }

}
