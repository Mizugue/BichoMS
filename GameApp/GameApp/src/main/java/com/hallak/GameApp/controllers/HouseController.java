package com.hallak.GameApp.controllers;

import com.hallak.GameApp.dtos.HouseDTO;
import com.hallak.GameApp.dtos.HouseOddsDTO;
import com.hallak.GameApp.dtos.HouseRegisterDTO;
import com.hallak.GameApp.dtos.HouseReturnOfRegisterDTO;
import com.hallak.GameApp.models.House;
import com.hallak.GameApp.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping(value = "/me")
    public ResponseEntity<HouseDTO> getMe(){
        return new ResponseEntity<>(houseService.getMe(), HttpStatus.OK);
    }


    @PostMapping(value = "/register")
    public ResponseEntity<HouseReturnOfRegisterDTO> saveHouse(@RequestBody HouseRegisterDTO houseDTO){
        return new ResponseEntity<>(houseService.saveHouse(houseDTO), HttpStatus.CREATED);
    }

    @PostMapping(value = "/odds")
    public ResponseEntity<HouseOddsDTO> newOdds(@RequestBody HouseOddsDTO houseDTO){
        return new ResponseEntity<>(houseService.newOdds(houseDTO), HttpStatus.CREATED);
    }

    //@GetMapping(value = "/odds")





}
