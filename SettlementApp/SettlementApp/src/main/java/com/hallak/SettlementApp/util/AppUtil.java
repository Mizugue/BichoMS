package com.hallak.BetApp.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppUtil {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
