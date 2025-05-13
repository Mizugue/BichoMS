package com.hallak.BetApp.services;

@org.springframework.cloud.openfeign.FeignClient(name = "game-service",
url = "")
public interface FeignClient {
}
