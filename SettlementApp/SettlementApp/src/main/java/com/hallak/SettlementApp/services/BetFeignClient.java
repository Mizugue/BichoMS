package com.hallak.SettlementApp.services;

import com.hallak.SettlementApp.dtos.BetReceived;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "betapp-service")
public interface BetFeignClient {

    @GetMapping(value = "/{id}")
    BetReceived findById(@PathVariable Long id);
}
