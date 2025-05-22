package com.hallak.SettlementApp.util;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.BetType;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;

public class HandlerOfSettlement {

    private HandlerOfSettlement(){
    }

    public static SettlementDTO process(BetReceived bet, ResultReceived result){

        if (bet.getType() == BetType.MILHAR_SECA) {
            return HandlerOfProcess.processMilharSeca(bet, result);
        } else if (bet.getType() == BetType.MILHAR_CERCADA) {
            return HandlerOfProcess.processMilharCercada(bet, result);
        } else if (bet.getType() == BetType.MILHAR_INVERTIDA_SECA) {
            return HandlerOfProcess.processMilharInvertidaSeca(bet, result);
        } else if (bet.getType() == BetType.MILHAR_INVERTIDA_CERCADA){
            return HandlerOfProcess.processMilharInvertidaCercada(bet , result);
        } else if (bet.getType() == BetType.CENTENA_SECA) {
            return HandlerOfProcess.processCentenaSeca(bet, result);
        } else if (bet.getType() == BetType.CENTENA_CERCADA) {
            return HandlerOfProcess.processCentenaCercada(bet, result);
        } else if (bet.getType() == BetType.CENTENA_INVERTIDA_SECA) {
            return HandlerOfProcess.processCentenaInvertidaSeca(bet, result);
        } else if (bet.getType() == BetType.CENTENA_INVERTIDA_CERCADA) {
            return HandlerOfProcess.processCentenaInvertidaCercada(bet, result);
        } else if (bet.getType() == BetType.DEZENA_SECA) {
            return HandlerOfProcess.processDezenaSeca(bet, result);
        } else if (bet.getType() == BetType.DEZENA_CERCADA) {
            return HandlerOfProcess.processDezenaCercada(bet, result);
        } else if (bet.getType() == BetType.DEZENA_INVERTIDA_SECA) {
            return HandlerOfProcess.processDezenaInvertidaSeca(bet, result);
        } else if (bet.getType() == BetType.DEZENA_INVERTIDA_CERCADA) {
            return HandlerOfProcess.processDezenaInvertidaCercada(bet, result);
        } else if (bet.getType() == BetType.DUQUE_DE_DEZENA) {
            return HandlerOfProcess.processDuqueDeDezena(bet, result);
        } else if (bet.getType() == BetType.TERNO_DE_DEZENA) {
            return HandlerOfProcess.processTernoDeDezena(bet, result);
        } else if (bet.getType() == BetType.GRUPO_SECO) {
            return HandlerOfProcess.processGrupoSeco(bet, result);
        } else if (bet.getType() == BetType.GRUPO_CERCADO) {
            return HandlerOfProcess.processGrupoCercado(bet, result);
        } else if (bet.getType() == BetType.DUPLA_DE_GRUPO_SECO) {
            return HandlerOfProcess.processDuplaDeGrupoSeco(bet, result);
        } else if (bet.getType() == BetType.DUPLA_DE_GRUPO_CERCADO) {
            return HandlerOfProcess.processDuplaDeGrupoCercado(bet, result);
        } else if (bet.getType() == BetType.TERNO_DE_GRUPO_SECO) {
            return HandlerOfProcess.processTernoDeGrupoSeco(bet, result);
        } else if (bet.getType() == BetType.TERNO_DE_GRUPO_CERCADO) {
            return HandlerOfProcess.processTernoDeGrupoCercado(bet, result);
        } else if (bet.getType() == BetType.PASSE) {
            return HandlerOfProcess.processPasse(bet, result);
        } else if (bet.getType() == BetType.PASSE_INVERTIDO) {
            return HandlerOfProcess.processPasseInvertido(bet, result);
        } else {
            throw new IllegalArgumentException("This BetType is not recognized: " + bet.getType());
        }


    }




}
