package com.hallak.BetApp.controllers;

import com.hallak.BetApp.dtos.user.UserAuthDTO;
import com.hallak.BetApp.dtos.user.UserDTO;
import com.hallak.BetApp.dtos.user.UserReturnOfAuthDTO;
import com.hallak.BetApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getMe(){
        return new ResponseEntity<>(userService.getMe(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserReturnOfAuthDTO> newUser(@RequestBody UserAuthDTO userAuthDTO){
        return new ResponseEntity<>(userService.newUser(userAuthDTO), HttpStatus.CREATED);
    }






}
