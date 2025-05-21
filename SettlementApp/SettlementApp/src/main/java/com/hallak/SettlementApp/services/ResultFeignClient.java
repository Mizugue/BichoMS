package com.hallak.SettlementApp.services;

import com.hallak.SettlementApp.dtos.ResultReceived;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "resultadoapp-service")
public interface ResultFeignClient {

    @GetMapping("/{id}")
    ResultReceived findByGameId(@PathVariable Long id);





}
