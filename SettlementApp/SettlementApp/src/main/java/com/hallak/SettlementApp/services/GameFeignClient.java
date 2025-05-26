package com.hallak.SettlementApp.services;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.BetType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "jogopp-service")
public interface GameFeignClient {

    @GetMapping(value = "/calculate-amount")
    Double calculateAmount(@RequestParam String username, @RequestParam BetType betType, @RequestParam Double amount);

}



