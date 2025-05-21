package com.hallak.SettlementApp.util;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.FinalBetStatus;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;

import java.time.LocalDateTime;
import java.util.List;

public class FinalHandler {

    private FinalHandler() {
    }

    public static SettlementDTO processWinner(BetReceived bet, List<String> luckyNumbers) {
        return createWinnerSettlementDTO(bet, luckyNumbers);
    }

    public static SettlementDTO processLoser(BetReceived bet, List<String> badNumbers) {
        return createLoserSettlementDTO(bet, badNumbers);
    }


    public static SettlementDTO processWinner(BetReceived bet, String luckyNumber) {
        return createWinnerSettlementDTO(bet, List.of(luckyNumber));
    }

    public static SettlementDTO processLoser(BetReceived bet, String badNumber) {
        return createLoserSettlementDTO(bet, List.of(badNumber));
    }

    private static SettlementDTO createWinnerSettlementDTO(BetReceived bet, List<String> luckyNumbers) {
        SettlementDTO settlementDTO = new SettlementDTO();
        settlementDTO.setDate(LocalDateTime.now());
        settlementDTO.setGame(bet.getGame());
        settlementDTO.setType(bet.getType());
        settlementDTO.setConsideredValues(luckyNumbers);
        settlementDTO.setFinalBetStatus(FinalBetStatus.WINNER);


        settlementDTO.setAmount(1000.0);



        return settlementDTO;
    }

    private static SettlementDTO createLoserSettlementDTO(BetReceived bet, List<String> badNumbers) {
        SettlementDTO settlementDTO = new SettlementDTO();
        settlementDTO.setDate(LocalDateTime.now());
        settlementDTO.setGame(bet.getGame());
        settlementDTO.setType(bet.getType());
        settlementDTO.setConsideredValues(badNumbers);
        settlementDTO.setFinalBetStatus(FinalBetStatus.LOSER);
        settlementDTO.setAmount(bet.getAmount() * -1);
        return settlementDTO;
    }
}
