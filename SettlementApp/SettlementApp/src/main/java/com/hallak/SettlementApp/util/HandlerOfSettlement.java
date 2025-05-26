package com.hallak.SettlementApp.util;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.BetType;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HandlerOfSettlement {

    @Autowired
    private HandlerOfProcess handlerOfProcess;

    private HandlerOfSettlement(HandlerOfProcess handlerOfProcess){
        this.handlerOfProcess = handlerOfProcess;
    }

    public SettlementDTO process(BetReceived bet, ResultReceived result) {
        return switch (bet.getType()) {
            case MILHAR_SECA -> handlerOfProcess.processMilharSeca(bet, result);
            case MILHAR_CERCADA -> handlerOfProcess.processMilharCercada(bet, result);
            case MILHAR_INVERTIDA_SECA -> handlerOfProcess.processMilharInvertidaSeca(bet, result);
            case MILHAR_INVERTIDA_CERCADA -> handlerOfProcess.processMilharInvertidaCercada(bet, result);
            case CENTENA_SECA -> handlerOfProcess.processCentenaSeca(bet, result);
            case CENTENA_CERCADA -> handlerOfProcess.processCentenaCercada(bet, result);
            case CENTENA_INVERTIDA_SECA -> handlerOfProcess.processCentenaInvertidaSeca(bet, result);
            case CENTENA_INVERTIDA_CERCADA -> handlerOfProcess.processCentenaInvertidaCercada(bet, result);
            case DEZENA_SECA -> handlerOfProcess.processDezenaSeca(bet, result);
            case DEZENA_CERCADA -> handlerOfProcess.processDezenaCercada(bet, result);
            case DEZENA_INVERTIDA_SECA -> handlerOfProcess.processDezenaInvertidaSeca(bet, result);
            case DEZENA_INVERTIDA_CERCADA -> handlerOfProcess.processDezenaInvertidaCercada(bet, result);
            case DUQUE_DE_DEZENA -> handlerOfProcess.processDuqueDeDezena(bet, result);
            case TERNO_DE_DEZENA -> handlerOfProcess.processTernoDeDezena(bet, result);
            case GRUPO_SECO -> handlerOfProcess.processGrupoSeco(bet, result);
            case GRUPO_CERCADO -> handlerOfProcess.processGrupoCercado(bet, result);
            case DUPLA_DE_GRUPO_SECO -> handlerOfProcess.processDuplaDeGrupoSeco(bet, result);
            case DUPLA_DE_GRUPO_CERCADO -> handlerOfProcess.processDuplaDeGrupoCercado(bet, result);
            case TERNO_DE_GRUPO_SECO -> handlerOfProcess.processTernoDeGrupoSeco(bet, result);
            case TERNO_DE_GRUPO_CERCADO -> handlerOfProcess.processTernoDeGrupoCercado(bet, result);
            case PASSE_SECO -> handlerOfProcess.processPasseSeco(bet, result);
            case PASSE_CERCADO -> handlerOfProcess.processPasseCercado(bet, result);
            case PASSE_INVERTIDO_SECO -> handlerOfProcess.proccessPasseInvertidoSeco(bet, result);
            case PASSE_INVERTIDO_CERCADO -> handlerOfProcess.processPasseInvertidoCercado(bet, result);
            default -> throw new IllegalArgumentException("This BetType is not recognized: " + bet.getType());
        };
    }





}
