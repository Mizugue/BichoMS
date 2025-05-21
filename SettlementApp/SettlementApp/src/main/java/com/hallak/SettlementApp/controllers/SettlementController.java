package com.hallak.SettlementApp.controllers;

import com.hallak.SettlementApp.dtos.SettlementDTO;
import com.hallak.SettlementApp.services.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettlementController {

    @Autowired
    private SettlementService settlementService;


    @PostMapping(value = "/{id}")
    public ResponseEntity<SettlementDTO> doCorrection(@PathVariable Long id){
        return new ResponseEntity<>(settlementService.doCorrection(id), HttpStatus.CREATED);

    }




}
