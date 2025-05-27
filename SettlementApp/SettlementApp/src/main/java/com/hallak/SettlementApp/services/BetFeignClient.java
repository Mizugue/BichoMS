package com.hallak.SettlementApp.services;

import com.hallak.SettlementApp.config.FeignClientConfig;
import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.BetReceivedFromBetByUsernameDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "betapp-service", configuration = FeignClientConfig.class)
public interface BetFeignClient {


    @GetMapping(value = "/api/bet/{id}")
    BetReceived findById(@PathVariable Long id);

    @GetMapping(value = "/api/bet/user/{username}")
    List<BetReceivedFromBetByUsernameDTO> findAllByUsername(@PathVariable String username);


}