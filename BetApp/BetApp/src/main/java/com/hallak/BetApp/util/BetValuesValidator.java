package com.hallak.BetApp.util;

import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.dtos.external.GameInterServiceDTO;
import com.hallak.BetApp.models.BetType;
import com.hallak.BetApp.services.GameFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BetValuesValidator {

    private final GameFeignClient gameFeignClient;

    @Autowired
    public BetValuesValidator(GameFeignClient gameFeignClient) {
        this.gameFeignClient = gameFeignClient;

    }


    public List<String> validateAndFormatValues(BetNewDTO betDTO) {
        List<String> values = betDTO.getValues();

        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("The list of values cannot be empty or null");
        }

        return switch (betDTO.getType()) {
            case MILHAR_SECA, MILHAR_CERCADA, MILHAR_INVERTIDA_SECA, MILHAR_INVERTIDA_CERCADA -> validateMilhar(values);
            case CENTENA_SECA, CENTENA_CERCADA, CENTENA_INVERTIDA_SECA, CENTENA_INVERTIDA_CERCADA -> validateCentena(values);
            case DEZENA_SECA, DEZENA_CERCADA, DEZENA_INVERTIDA_SECA, DEZENA_INVERTIDA_CERCADA -> validateDezena(values);
            case DUQUE_DE_DEZENA -> validateDuqueDeDezena(values);
            case TERNO_DE_DEZENA -> validateTernoDeDezena(values);
            case GRUPO_SECO, GRUPO_CERCADO -> validateGrupo(values, 1);
            case DUPLA_DE_GRUPO_SECO, DUPLA_DE_GRUPO_CERCADO -> validateGrupo(values, 2);
            case TERNO_DE_GRUPO_SECO, TERNO_DE_GRUPO_CERCADO -> validateGrupo(values, 3);
            case PASSE_SECO, PASSE_INVERTIDO_SECO, PASSE_CERCADO, PASSE_INVERTIDO_CERCADO -> validatePasse(values);
        };
    }


    public BetType validateBetType(BetNewDTO betDTO){
        GameInterServiceDTO game = gameFeignClient.findGameById(betDTO.getGameId());
        if (!game.getHouse().getOdds().containsKey(betDTO.getType().toString())){
            throw new IllegalArgumentException("The BetType shall exist in the house");
        }
        return betDTO.getType();

    }


    private static List<String> validateMilhar(List<String> values) {
        if (values.size() > 1 || !values.getFirst().matches("\\d{4}")) {
            throw new IllegalArgumentException("In the betTypes: " + BetType.MILHAR_SECA + " , " + BetType.MILHAR_CERCADA + " , " + BetType.MILHAR_INVERTIDA_SECA + " , " + BetType.MILHAR_INVERTIDA_CERCADA + " are allowed only one value of 4 digits");
        }
        return values;
    }

    private static List<String> validateCentena(List<String> values) {
        if (values.size() > 1 || !values.getFirst().matches("\\d{3}")) {
            throw new IllegalArgumentException("In the betTypes: " + BetType.CENTENA_SECA + " , " + BetType.CENTENA_CERCADA + " , " + BetType.CENTENA_INVERTIDA_SECA + " , " + BetType.CENTENA_INVERTIDA_CERCADA + " are allowed only one value of 3 digits");
        }
        return values;
    }

    private static List<String> validateDezena(List<String> values) {
        if (values.size() > 1 || !values.getFirst().matches("\\d{2}")){
            throw new IllegalArgumentException("In the betTypes: " + BetType.DEZENA_SECA+ " , " + BetType.DEZENA_CERCADA + " , " + BetType.DEZENA_INVERTIDA_SECA + " , " + BetType.DEZENA_INVERTIDA_CERCADA + " are allowed only one value of 2 digits");
        }
        return values;
    }


    private static List<String> validateDuqueDeDezena(List<String> values) {
        if (values.size() > 2 || !values.getFirst().matches("\\d{2}") || !values.get(1).matches("\\d{2}")) {
            throw new IllegalArgumentException("In the betTypes: " + BetType.DUQUE_DE_DEZENA + " are allowed only two values of 2 digits each");
        }
        return values;
    }

    private static List<String> validateTernoDeDezena(List<String> values) {
        if (values.size() > 2 || !values.getFirst().matches("\\d{2}") || !values.get(1).matches("\\d{2}") || !values.get(2).matches("\\d{2}")) {
            throw new IllegalArgumentException("In the betTypes: " + BetType.TERNO_DE_DEZENA + " are allowed only three values of 2 digits each");
        }
        return values;
    }


    private static List<String> validateGrupo(List<String> values, int i) {
        if (i == 1) {
            if (values.size() > 1 || !(Integer.parseInt(values.getFirst()) >= 1) || !(Integer.parseInt(values.getFirst()) <= 25)) {
                throw new IllegalArgumentException("In the betTypes: " + BetType.GRUPO_SECO + " , " + BetType.GRUPO_CERCADO + " are allowed only one value between 1 - 25 of 2 digits each");
            }
        } else if (i == 2) {
            if (values.size() > 2 || !(Integer.parseInt(values.getFirst()) >= 1) || !(Integer.parseInt(values.getFirst()) <= 25) || !(Integer.parseInt(values.get(1)) >= 1) || !(Integer.parseInt(values.get(1)) <= 25)) {
                throw new IllegalArgumentException("In the betTypes: " + BetType.DUPLA_DE_GRUPO_SECO + " , " + BetType.DUPLA_DE_GRUPO_CERCADO + " are allowed only two values between 1 - 25 of 2 digits each");
            }
        } else if (i == 3) {
            if (values.size() > 3 || !(Integer.parseInt(values.getFirst()) >= 1) || !(Integer.parseInt(values.getFirst()) <= 25) || !(Integer.parseInt(values.get(1)) >= 1) || !(Integer.parseInt(values.get(1)) <= 25) || !(Integer.parseInt(values.get(2)) >= 1) || !(Integer.parseInt(values.get(2)) <= 25)) {
                throw new IllegalArgumentException("In the betTypes: " + BetType.TERNO_DE_GRUPO_SECO + " , " + BetType.TERNO_DE_GRUPO_CERCADO + " are allowed only three values between 1 - 25 of 2 digits each");
            }
        }
        return values;
    }

    private static List<String> validatePasse(List<String> values) {
        if (values.size() > 2 || !(Integer.parseInt(values.getFirst()) >= 1) || !(Integer.parseInt(values.getFirst()) <= 25) || !(Integer.parseInt(values.get(1)) >= 1) || !(Integer.parseInt(values.get(1)) <= 25)) {
                throw new IllegalArgumentException("In the betTypes: " + BetType.PASSE_SECO + " , " + BetType.PASSE_INVERTIDO_SECO + BetType.PASSE_CERCADO + " , " + BetType.PASSE_INVERTIDO_CERCADO + " are allowed only two values between 1 - 25 of 2 digits each");
            }
        return values;
    }















}
