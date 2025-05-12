package com.hallak.BetApp.services;

import com.hallak.BetApp.models.User;
import com.hallak.BetApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatedUserService {


    @Autowired
    private UserRepository userRepository;

    protected User authenticated() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwt = (Jwt) authentication.getPrincipal();
            String username = jwt.getClaim("username");
            return userRepository.findByUsername(username).get();
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }


}
