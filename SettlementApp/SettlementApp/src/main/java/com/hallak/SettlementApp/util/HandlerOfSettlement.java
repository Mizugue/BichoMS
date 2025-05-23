package com.hallak.SettlementApp.util;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.BetType;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;

public class HandlerOfSettlement {

    private HandlerOfSettlement(){
    }

    public static SettlementDTO process(BetReceived bet, ResultReceived result) {
        return switch (bet.getType()) {
            case MILHAR_SECA -> HandlerOfProcess.processMilharSeca(bet, result);
            case MILHAR_CERCADA -> HandlerOfProcess.processMilharCercada(bet, result);
            case MILHAR_INVERTIDA_SECA -> HandlerOfProcess.processMilharInvertidaSeca(bet, result);
            case MILHAR_INVERTIDA_CERCADA -> HandlerOfProcess.processMilharInvertidaCercada(bet, result);
            case CENTENA_SECA -> HandlerOfProcess.processCentenaSeca(bet, result);
            case CENTENA_CERCADA -> HandlerOfProcess.processCentenaCercada(bet, result);
            case CENTENA_INVERTIDA_SECA -> HandlerOfProcess.processCentenaInvertidaSeca(bet, result);
            case CENTENA_INVERTIDA_CERCADA -> HandlerOfProcess.processCentenaInvertidaCercada(bet, result);
            case DEZENA_SECA -> HandlerOfProcess.processDezenaSeca(bet, result);
            case DEZENA_CERCADA -> HandlerOfProcess.processDezenaCercada(bet, result);
            case DEZENA_INVERTIDA_SECA -> HandlerOfProcess.processDezenaInvertidaSeca(bet, result);
            case DEZENA_INVERTIDA_CERCADA -> HandlerOfProcess.processDezenaInvertidaCercada(bet, result);
            case DUQUE_DE_DEZENA -> HandlerOfProcess.processDuqueDeDezena(bet, result);
            case TERNO_DE_DEZENA -> HandlerOfProcess.processTernoDeDezena(bet, result);
            case GRUPO_SECO -> HandlerOfProcess.processGrupoSeco(bet, result);
            case GRUPO_CERCADO -> HandlerOfProcess.processGrupoCercado(bet, result);
            case DUPLA_DE_GRUPO_SECO -> HandlerOfProcess.processDuplaDeGrupoSeco(bet, result);
            case DUPLA_DE_GRUPO_CERCADO -> HandlerOfProcess.processDuplaDeGrupoCercado(bet, result);
            case TERNO_DE_GRUPO_SECO -> HandlerOfProcess.processTernoDeGrupoSeco(bet, result);
            case TERNO_DE_GRUPO_CERCADO -> HandlerOfProcess.processTernoDeGrupoCercado(bet, result);
            case PASSE_SECO -> HandlerOfProcess.processPasseSeco(bet, result);
            case PASSE_CERCADO -> HandlerOfProcess.processPasseCercado(bet, result);
            case PASSE_INVERTIDO_SECO -> HandlerOfProcess.proccessPasseInvertidoSeco(bet, result);
            case PASSE_INVERTIDO_CERCADO -> HandlerOfProcess.processPasseInvertidoCercado(bet, result);
            default -> throw new IllegalArgumentException("This BetType is not recognized: " + bet.getType());
        };
    }





}
