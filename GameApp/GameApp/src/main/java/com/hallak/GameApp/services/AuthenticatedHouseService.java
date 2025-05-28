package com.hallak.GameApp.services;

import com.hallak.GameApp.exceptions.exception.ResourceNotFoundException;
import com.hallak.GameApp.models.House;
import com.hallak.GameApp.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedHouseService {

    @Autowired
    private HouseRepository houseRepository;

    protected House authenticated() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwt = (Jwt) authentication.getPrincipal();
            String username = jwt.getClaim("username");
            return houseRepository.findByUsername(username).get();
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }


}
