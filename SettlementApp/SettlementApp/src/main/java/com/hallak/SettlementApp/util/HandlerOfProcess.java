package com.hallak.SettlementApp.util;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;

import java.util.List;
import java.util.Objects;

public class HandlerOfProcess {

    private HandlerOfProcess(){
    }

    protected static SettlementDTO processMilharSeca(BetReceived bet, ResultReceived result){
        if (Objects.equals(bet.getValues().getFirst(), result.getFirst())){
            return FinalHandler.processWinner(bet, bet.getValues().getFirst());
        } else
            return FinalHandler.processLoser(bet, bet.getValues().getFirst());
    }


    protected static SettlementDTO processMilharCercada(BetReceived bet, ResultReceived result) {
        if (Objects.equals(bet.getValues().getFirst(), result.getFirst())
                || Objects.equals(bet.getValues().getFirst(), result.getSecond())
                || Objects.equals(bet.getValues().getFirst(), result.getThird())
                || Objects.equals(bet.getValues().getFirst(), result.getFourth())
                || Objects.equals(bet.getValues().getFirst(), result.getFifth())){
            return FinalHandler.processWinner(bet, bet.getValues().getFirst());
        } else {
            return FinalHandler.processLoser(bet, bet.getValues().getFirst());
        }
    }

    protected static SettlementDTO processMilharInvertida(BetReceived bet, ResultReceived result) {
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst());
        for (String number : invertedValues){
            if (Objects.equals(number, result.getFirst())){
                return FinalHandler.processWinner(bet, number);
            }
        } return FinalHandler.processLoser(bet, invertedValues);

    }

    public static SettlementDTO processCentenaSeca(BetReceived bet, ResultReceived result) {
        String centBet = bet.getValues().getFirst().substring(1);
        String centResult = result.getFirst().substring(1);


        if (Objects.equals(centBet, centResult)){
            return FinalHandler.processWinner(bet, centBet);
        } else
            return FinalHandler.processLoser(bet, centBet);
    }




    public static SettlementDTO processCentenaCercada(BetReceived bet, ResultReceived result) {
        String centBet = bet.getValues().getFirst().substring(1);

        if (Objects.equals(centBet, result.getFirst().substring(1))
                || Objects.equals(centBet, result.getSecond().substring(1))
                || Objects.equals(centBet, result.getThird().substring(1))
                || Objects.equals(centBet, result.getFourth().substring(1))
                || Objects.equals(centBet, result.getFifth().substring(1))){
            return FinalHandler.processWinner(bet, centBet);
        } else {
            return FinalHandler.processLoser(bet, centBet);
        }
    }

    public static SettlementDTO processCentenaInvertida(BetReceived bet, ResultReceived result) {
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst().substring(1));
        String centResult = result.getFirst().substring(1);

        for (String number : invertedValues){
            if (Objects.equals(number, centResult)){
                return FinalHandler.processWinner(bet, number);
            }
        } return FinalHandler.processLoser(bet, invertedValues);

    }

    public static SettlementDTO processDezenaSeca(BetReceived bet, ResultReceived result) {
        String dezBet = bet.getValues().getFirst().substring(2);
        String dezResult = result.getFirst().substring(2);


        if (Objects.equals(dezBet, dezResult)){
            return FinalHandler.processWinner(bet, dezBet);
        } else
            return FinalHandler.processLoser(bet, dezBet);
    }


    public static SettlementDTO processDezenaCercada(BetReceived bet, ResultReceived result) {
        String dezBet = bet.getValues().getFirst().substring(2);

        if (Objects.equals(dezBet, result.getFirst().substring(2))
                || Objects.equals(dezBet, result.getSecond().substring(2))
                || Objects.equals(dezBet, result.getThird().substring(2))
                || Objects.equals(dezBet, result.getFourth().substring(2))
                || Objects.equals(dezBet, result.getFifth().substring(2))){
            return FinalHandler.processWinner(bet, dezBet);
        } else {
            return FinalHandler.processLoser(bet, dezBet);
        }
    }

    public static SettlementDTO processDezenaInvertida(BetReceived bet, ResultReceived result) {
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst().substring(2));
        String dezResult = result.getFirst().substring(1);

        for (String number : invertedValues){
            if (Objects.equals(number, dezResult)){
                return FinalHandler.processWinner(bet, number);
            }
        } return FinalHandler.processLoser(bet, invertedValues);

    }

    public static SettlementDTO processDuqueDeDezena(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processTernoDeDezena(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processGrupoSeco(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processGrupoCercado(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processDuplaDeGrupoSeco(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processDuplaDeGrupoCercado(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processTernoDeGrupoSeco(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processTernoDeGrupoCercado(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processPasse(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }

    public static SettlementDTO processPasseInvertido(BetReceived bet, ResultReceived result) {
        return new SettlementDTO();
    }
}
