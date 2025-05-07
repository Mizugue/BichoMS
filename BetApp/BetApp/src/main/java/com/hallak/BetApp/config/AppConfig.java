package com.hallak.BetApp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    private ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
