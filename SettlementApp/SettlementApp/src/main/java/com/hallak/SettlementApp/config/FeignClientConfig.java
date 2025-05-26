package com.hallak.SettlementApp.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor apiKeyRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-API-KEY", "settlementapp-secret-key");
        };
    }
}