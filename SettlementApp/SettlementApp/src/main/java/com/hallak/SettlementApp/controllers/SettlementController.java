package com.hallak.SettlementApp.controllers;

import com.hallak.SettlementApp.dtos.SettlementDTO;
import com.hallak.SettlementApp.services.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SettlementController {

    @Autowired
    private SettlementService settlementService;


    @PostMapping(value = "/bet/{id}")
    public ResponseEntity<SettlementDTO> doCorrectionByBetId(@PathVariable Long id){
        return new ResponseEntity<>(settlementService.doCorrectionByBetId(id), HttpStatus.CREATED);

    }

    @PostMapping(value = "/bet/user/{username}")
    public ResponseEntity<List<SettlementDTO>> doCorrectionByUsernameFromUser(@PathVariable String username){
        return new ResponseEntity<>(settlementService.doCorrectionByUsernameFromUser(username), HttpStatus.CREATED);

    }





}
