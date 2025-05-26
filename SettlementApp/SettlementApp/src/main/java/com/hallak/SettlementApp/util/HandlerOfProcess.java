package com.hallak.SettlementApp.util;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;
import java.util.List;
import java.util.Objects;

public class HandlerOfProcess {


    private HandlerOfProcess() {
    }


    protected static SettlementDTO processMilharSeca(BetReceived bet, ResultReceived result) {
        if (Objects.equals(bet.getValues().getFirst(), result.getFirst())) {
            return FinalHandler.processWinner(bet, bet.getValues().getFirst());
        } else
            return FinalHandler.processLoser(bet, bet.getValues().getFirst());
    }


    protected static SettlementDTO processMilharCercada(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result);
        String betMil = bet.getValues().getFirst();

        if (resultWrapper.contains(betMil)) {
            return FinalHandler.processWinner(bet, betMil);
        } else
            return FinalHandler.processLoser(bet, betMil);
    }


    protected static SettlementDTO processMilharInvertidaSeca(BetReceived bet, ResultReceived result) {
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst());

        for (String number : invertedValues) {
            if (Objects.equals(number, result.getFirst())) {
                return FinalHandler.processWinner(bet, number);
            }
        }
        return FinalHandler.processLoser(bet, invertedValues);
    }

    protected static SettlementDTO processMilharInvertidaCercada(BetReceived bet, ResultReceived result) {
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst());
        ResultWrapper resultWrapper = new ResultWrapper(result);


        for (String number : invertedValues) {
            if (resultWrapper.contains(number)) {
                return FinalHandler.processWinner(bet, number);
            }
        }
        return FinalHandler.processLoser(bet, invertedValues);
    }

    protected static SettlementDTO processCentenaSeca(BetReceived bet, ResultReceived result) {
        String centBet = bet.getValues().getFirst().substring(1);
        String centResult = result.getFirst().substring(1);

        if (Objects.equals(centBet, centResult)) {
            return FinalHandler.processWinner(bet, centBet);
        } else
            return FinalHandler.processLoser(bet, centBet);
    }


    protected static SettlementDTO processCentenaCercada(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 1);
        String centBet = bet.getValues().getFirst().substring(1);

        if (resultWrapper.contains(centBet)) {
            return FinalHandler.processWinner(bet, centBet);
        } else {
            return FinalHandler.processLoser(bet, centBet);
        }
    }

    protected static SettlementDTO processCentenaInvertidaSeca(BetReceived bet, ResultReceived result) {
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst().substring(1));
        String centResult = result.getFirst().substring(1);

        for (String number : invertedValues) {
            if (Objects.equals(number, centResult)) {
                return FinalHandler.processWinner(bet, number);
            }
        }
        return FinalHandler.processLoser(bet, invertedValues);

    }

    protected static SettlementDTO processCentenaInvertidaCercada(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 1);
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst().substring(1));

        for (String number : invertedValues) {
            if (resultWrapper.contains(number)) {
                return FinalHandler.processWinner(bet, number);
            }
        }
        return FinalHandler.processLoser(bet, invertedValues);

    }

    protected static SettlementDTO processDezenaSeca(BetReceived bet, ResultReceived result) {
        String dezBet = bet.getValues().getFirst().substring(2);
        String dezResult = result.getFirst().substring(2);

        if (Objects.equals(dezBet, dezResult)) {
            return FinalHandler.processWinner(bet, dezBet);
        } else
            return FinalHandler.processLoser(bet, dezBet);
    }


    protected static SettlementDTO processDezenaCercada(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);
        String dezBet = bet.getValues().getFirst().substring(2);

        if (resultWrapper.contains(dezBet)) {
            return FinalHandler.processWinner(bet, dezBet);
        } else {
            return FinalHandler.processLoser(bet, dezBet);
        }
    }

    protected static SettlementDTO processDezenaInvertidaSeca(BetReceived bet, ResultReceived result) {
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst().substring(2));
        String dezResult = result.getFirst().substring(1);

        for (String number : invertedValues) {
            if (Objects.equals(number, dezResult)) {
                return FinalHandler.processWinner(bet, number);
            }
        }
        return FinalHandler.processLoser(bet, invertedValues);
    }

    protected static SettlementDTO processDezenaInvertidaCercada(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);
        List<String> invertedValues = NumberPermutationGenerator.generatePermutation(bet.getValues().getFirst().substring(2));

        for (String number : invertedValues) {
            if (resultWrapper.contains(number)) {
                return FinalHandler.processWinner(bet, number);
            }
        }
        return FinalHandler.processLoser(bet, invertedValues);
    }

    protected static SettlementDTO processDuqueDeDezena(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);
        String dez1 = bet.getValues().getFirst().substring(2);
        String dez2 = bet.getValues().get(1).substring(2);

        if (resultWrapper.contains(dez1) && resultWrapper.contains(dez2)) {
            return FinalHandler.processWinner(bet, bet.getValues());
        } else {
            return FinalHandler.processLoser(bet, bet.getValues());
        }
    }


    protected static SettlementDTO processTernoDeDezena(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);
        String dez1 = bet.getValues().getFirst().substring(2);
        String dez2 = bet.getValues().get(1).substring(2);
        String dez3 = bet.getValues().get(2).substring(2);

        if (resultWrapper.contains(dez1) && resultWrapper.contains(dez2) && resultWrapper.contains(dez3)) {
            return FinalHandler.processWinner(bet, bet.getValues());
        } else {
            return FinalHandler.processLoser(bet, bet.getValues());
        }
    }


    protected static SettlementDTO processGrupoSeco(BetReceived bet, ResultReceived result) {
        String animal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();

        for (Integer number : TableAnimal.getNumbersForAnimal(animal)) {
            if (Integer.parseInt(result.getFirst().substring(2)) == number) {
                return FinalHandler.processWinner(bet, animal);
            }
        }
        return FinalHandler.processLoser(bet, animal);
    }

    protected static SettlementDTO processGrupoCercado(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);
        String animal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();

        for (Integer number : TableAnimal.getNumbersForAnimal(animal)) {
            if (resultWrapper.contains(number.toString())) {
                return FinalHandler.processWinner(bet, animal);
            }
        }
        return FinalHandler.processLoser(bet, animal);
    }

    protected static SettlementDTO processDuplaDeGrupoSeco(BetReceived bet, ResultReceived result) {
        String firstAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();
        String secondAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(1).substring(2))).get();

        List<Integer> numbersOfFirstAnimal = TableAnimal.getNumbersForAnimal(firstAnimal);
        List<Integer> numbersOfSecondAnimal = TableAnimal.getNumbersForAnimal(secondAnimal);


        if      (numbersOfFirstAnimal.contains(Integer.parseInt(result.getFirst().substring(2))) && (numbersOfSecondAnimal.contains(Integer.parseInt(result.getSecond().substring(2))))
                ||
                (numbersOfSecondAnimal.contains(Integer.parseInt(result.getFirst().substring(2)))) && (numbersOfFirstAnimal.contains(Integer.parseInt(result.getSecond().substring(2))))){
            return FinalHandler.processWinner(bet, List.of(firstAnimal, secondAnimal));
        }
        return FinalHandler.processLoser(bet, List.of(firstAnimal, secondAnimal));
    }

    protected static SettlementDTO processDuplaDeGrupoCercado(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);
        String firstAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();
        String secondAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(1).substring(2))).get();

        boolean checker = false;

        List<Integer> numbersOfFirstAnimal = TableAnimal.getNumbersForAnimal(firstAnimal);
        List<Integer> numbersOfSecondAnimal = TableAnimal.getNumbersForAnimal(secondAnimal);

        for (Integer number : numbersOfFirstAnimal){
            if (resultWrapper.contains(number.toString())){
                checker = true;
            }
        }

        if (checker) {
            for (Integer number : numbersOfSecondAnimal){
                if (resultWrapper.contains(number.toString())){
                    return FinalHandler.processWinner(bet, List.of(firstAnimal, secondAnimal));
                }
            }
        }

        return FinalHandler.processLoser(bet, List.of(firstAnimal, secondAnimal));
    }

    protected static SettlementDTO processTernoDeGrupoSeco(BetReceived bet, ResultReceived result) {
        String firstAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();
        String secondAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(1).substring(2))).get();
        String thirdAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(2).substring(2))).get();

        List<Integer> numbersOfFirstAnimal = TableAnimal.getNumbersForAnimal(firstAnimal);
        List<Integer> numbersOfSecondAnimal = TableAnimal.getNumbersForAnimal(secondAnimal);
        List<Integer> numbersOfThirdAnimal = TableAnimal.getNumbersForAnimal(thirdAnimal);

        int resultFirstNum = Integer.parseInt(result.getFirst().substring(2));
        int resultSecondNum = Integer.parseInt(result.getSecond().substring(2));
        int resultThirdNum = Integer.parseInt(result.getThird().substring(2));

        boolean fstResFstBet = numbersOfFirstAnimal.contains(resultFirstNum);
        boolean fstResSndBet = numbersOfSecondAnimal.contains(resultFirstNum);
        boolean fstResTrdBet = numbersOfThirdAnimal.contains(resultFirstNum);

        boolean sndResFstBet = numbersOfFirstAnimal.contains(resultSecondNum);
        boolean sndResSndBet = numbersOfSecondAnimal.contains(resultSecondNum);
        boolean sndResTrdBet = numbersOfThirdAnimal.contains(resultSecondNum);

        boolean trdResFstBet = numbersOfFirstAnimal.contains(resultThirdNum);
        boolean trdResSndBet = numbersOfSecondAnimal.contains(resultThirdNum);
        boolean trdResTrdBet = numbersOfThirdAnimal.contains(resultThirdNum);

        if ( (fstResFstBet && sndResSndBet && trdResTrdBet) ||
             (fstResFstBet && sndResTrdBet && trdResSndBet) ||

             (fstResSndBet && sndResFstBet && trdResTrdBet) ||
             (fstResSndBet && sndResTrdBet && trdResFstBet) ||

             (fstResTrdBet && sndResFstBet && trdResSndBet) ||
             (fstResTrdBet && sndResSndBet && trdResFstBet)
           ) {
            return FinalHandler.processWinner(bet, List.of(firstAnimal, secondAnimal, thirdAnimal));
        }
        return FinalHandler.processLoser(bet, List.of(firstAnimal, secondAnimal, thirdAnimal));
    }


    public static SettlementDTO processTernoDeGrupoCercado(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);

        String firstAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();
        String secondAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(1).substring(2))).get();
        String thirdAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(2).substring(2))).get();

        boolean checkerFirst = false;
        boolean checkerSecond = false;

        List<Integer> numbersOfFirstAnimal = TableAnimal.getNumbersForAnimal(firstAnimal);
        List<Integer> numbersOfSecondAnimal = TableAnimal.getNumbersForAnimal(secondAnimal);
        List<Integer> numbersOfThirdAnimal = TableAnimal.getNumbersForAnimal(thirdAnimal);


        for (Integer number : numbersOfFirstAnimal){
            if (resultWrapper.contains(number.toString())){
                checkerFirst = true;
            }
        }

        if (checkerFirst) {
            for (Integer number : numbersOfSecondAnimal){
                if (resultWrapper.contains(number.toString())){
                    checkerSecond = true;
                }
            }
        }

        if (checkerSecond){
            for (Integer number : numbersOfThirdAnimal) {
                if (resultWrapper.contains(number.toString())){
                    return FinalHandler.processWinner(bet, List.of(firstAnimal, secondAnimal, thirdAnimal));
                }
            }
        }


        return FinalHandler.processLoser(bet, List.of(firstAnimal, secondAnimal, thirdAnimal));
    }



    public static SettlementDTO processPasseSeco(BetReceived bet, ResultReceived result) {
        String firstAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();
        String secondAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(1).substring(2))).get();

        List<Integer> numbersOfFirstAnimal = TableAnimal.getNumbersForAnimal(firstAnimal);
        List<Integer> numbersOfSecondAnimal = TableAnimal.getNumbersForAnimal(secondAnimal);


        if (numbersOfFirstAnimal.contains(Integer.parseInt(result.getFirst().substring(2)))
                && numbersOfSecondAnimal.contains(Integer.parseInt(result.getSecond().substring(2)))) {
            return FinalHandler.processWinner(bet, List.of(firstAnimal, secondAnimal));
        }
        return FinalHandler.processLoser(bet, List.of(firstAnimal, secondAnimal));
    }


    public static SettlementDTO processPasseCercado(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);
        String firstAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();
        String secondAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(1).substring(2))).get();

        List<Integer> numbersOfFirstAnimal = TableAnimal.getNumbersForAnimal(firstAnimal);
        List<Integer> numbersOfSecondAnimal = TableAnimal.getNumbersForAnimal(secondAnimal);

        for (Integer a : numbersOfFirstAnimal) {
            if (resultWrapper.contains(a.toString())) {
                for (Integer b : numbersOfSecondAnimal) {
                    if (resultWrapper.contains(b.toString()) && resultWrapper.getValues().indexOf(a.toString()) < resultWrapper.getValues().indexOf(b.toString())) {
                        return FinalHandler.processWinner(bet, List.of(firstAnimal, secondAnimal));
                    }
                }
            }
        }
        return FinalHandler.processLoser(bet, List.of(firstAnimal, secondAnimal));
    }


    public static SettlementDTO proccessPasseInvertidoSeco(BetReceived bet, ResultReceived result) {
        String firstAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();
        String secondAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(1).substring(2))).get();

        List<Integer> numbersOfFirstAnimal = TableAnimal.getNumbersForAnimal(firstAnimal);
        List<Integer> numbersOfSecondAnimal = TableAnimal.getNumbersForAnimal(secondAnimal);


        if (numbersOfFirstAnimal.contains(Integer.parseInt(result.getSecond().substring(2)))
                && numbersOfSecondAnimal.contains(Integer.parseInt(result.getFirst().substring(2)))) {
            return FinalHandler.processWinner(bet, List.of(secondAnimal, firstAnimal));
        }
        return FinalHandler.processLoser(bet, List.of(secondAnimal, firstAnimal));
    }


    public static SettlementDTO processPasseInvertidoCercado(BetReceived bet, ResultReceived result) {
        ResultWrapper resultWrapper = new ResultWrapper(result, 2);
        String firstAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().getFirst().substring(2))).get();
        String secondAnimal = TableAnimal.getAnimalByNumber(Integer.parseInt(bet.getValues().get(1).substring(2))).get();

        List<Integer> numbersOfFirstAnimal = TableAnimal.getNumbersForAnimal(firstAnimal);
        List<Integer> numbersOfSecondAnimal = TableAnimal.getNumbersForAnimal(secondAnimal);

        for (Integer a : numbersOfFirstAnimal) {
            if (resultWrapper.contains(a.toString())) {
                for (Integer b : numbersOfSecondAnimal) {
                    if (resultWrapper.contains(b.toString()) && resultWrapper.getValues().indexOf(a.toString()) > resultWrapper.getValues().indexOf(b.toString())) {
                        return FinalHandler.processWinner(bet, List.of(firstAnimal, secondAnimal));
                    }
                }
            }
        }
        return FinalHandler.processLoser(bet, List.of(firstAnimal, secondAnimal));
    }
}

//OBS: Diferenca entre passe e dupla de grupo. Passe importa ordem, dupla nao!



