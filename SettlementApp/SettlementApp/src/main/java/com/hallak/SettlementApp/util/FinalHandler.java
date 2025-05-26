package com.hallak.SettlementApp.util;

import com.hallak.SettlementApp.dtos.*;
import com.hallak.SettlementApp.services.GameFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FinalHandler {

    private final GameFeignClient gameFeignClient;

    @Autowired
    protected FinalHandler(GameFeignClient gameFeignClient) {
        this.gameFeignClient = gameFeignClient;
    }

    protected SettlementDTO processWinner(BetReceived bet, List<String> luckyNumbers) {
        return createWinnerSettlementDTO(bet, luckyNumbers);
    }

    protected SettlementDTO processLoser(BetReceived bet, List<String> badNumbers) {
        return createLoserSettlementDTO(bet, badNumbers);
    }

    protected SettlementDTO processWinner(BetReceived bet, String luckyNumber) {
        return createWinnerSettlementDTO(bet, List.of(luckyNumber));
    }

    protected SettlementDTO processLoser(BetReceived bet, String badNumber) {
        return createLoserSettlementDTO(bet, List.of(badNumber));
    }

    private SettlementDTO createWinnerSettlementDTO(BetReceived bet, List<String> luckyNumbers) {
        SettlementDTO settlementDTO = new SettlementDTO();
        settlementDTO.setDate(LocalDateTime.now());
        settlementDTO.setGame(bet.getGame());
        settlementDTO.setType(bet.getType());
        settlementDTO.setConsideredValues(luckyNumbers);
        settlementDTO.setFinalBetStatus(FinalBetStatus.WINNER);
        settlementDTO.setAmount(amountCalculator(bet.getGame().getHouse().getUsername(), bet.getAmount(), bet.getType()));
        return settlementDTO;
    }

    private SettlementDTO createLoserSettlementDTO(BetReceived bet, List<String> badNumbers) {
        SettlementDTO settlementDTO = new SettlementDTO();
        settlementDTO.setDate(LocalDateTime.now());
        settlementDTO.setGame(bet.getGame());
        settlementDTO.setType(bet.getType());
        settlementDTO.setConsideredValues(badNumbers);
        settlementDTO.setFinalBetStatus(FinalBetStatus.LOSER);
        settlementDTO.setAmount(bet.getAmount() * -1);
        return settlementDTO;
    }

    private Double amountCalculator(String houseName, Double amount, BetType betType){
        return gameFeignClient.calculateAmount(houseName, betType, amount);
    }
}

