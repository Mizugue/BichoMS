package com.hallak.ResultApp.config;

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
