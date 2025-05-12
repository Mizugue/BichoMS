package com.hallak.BetApp.controllers;

import com.hallak.BetApp.dtos.bet.BetDTO;
import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.bet.BetReturnOfNewDTO;
import com.hallak.BetApp.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class BetController {

    @Autowired
    private BetService betService;

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping()
    public ResponseEntity<BetReturnOfNewDTO> newBet(@RequestBody BetNewDTO betDTO){
        return new ResponseEntity<>(betService.newBet(betDTO), HttpStatus.CREATED);
    }


}
